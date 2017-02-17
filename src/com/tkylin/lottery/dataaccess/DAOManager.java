package com.tkylin.lottery.dataaccess;


import com.ibatis.common.resources.Resources;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.DaoManagerBuilder;
import com.lamfire.utils.XMLParser;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


@SuppressWarnings("unchecked")
public class DAOManager {
	
	static final Logger LOGGER = Logger.getLogger(DAOManager.class);

	protected static final Map<Class<?>, DAOManager> DaoMap = new HashMap<Class<?>, DAOManager>();
	protected static final Collection<DAOManager> ManagerList = new HashSet<DAOManager>();

	static final String ConfigFiles = "ibatis-dao.xml";

	protected static final ThreadLocal<Map> CurrentDaoInstances = new ThreadLocal<Map>();
	
	static{
	    try{
            XMLParser xml = XMLParser.load(ConfigFiles, DAOManager.class);
            String[] values = xml.getNodeValues("/daoConfig-files/daoConfig-file");

    	    if(values == null || values.length == 0){
    	        LOGGER.error("The xml path '/daoConfig-files/daoConfig-file' not found.");
    	        throw new RuntimeException("The xml path '/daoConfig-files/daoConfig-file' not found.");
    	    }
    		
    	    for(String val:values){
    	        LOGGER.info("parse config file - " + val);
                ManagerList.add(new DAOManager(val));
            }
    	    
    		LOGGER.info("DAOManager init successfully");
	    }catch(Exception e){
	        throw new RuntimeException(e.getMessage(),e);
	    }
	}
	
	
	private DaoManager manager;

	private DAOManager(String configFile) {
		manager = buildDaoManager(configFile);
	}

	public <T> T getDaoInstance(Class<?> clazz) {
		Map<Class<?>,T> daoInstanceMap = CurrentDaoInstances.get();
		if(daoInstanceMap == null){
			daoInstanceMap = new HashMap<Class<?>, T>();
			CurrentDaoInstances.set(daoInstanceMap);
		}
		T instance =  daoInstanceMap.get(clazz);
		if(instance == null){
			try{
    			instance =  (T) manager.getDao(clazz);
    			daoInstanceMap.put(clazz, instance);
			}catch(Exception e){
				
			}
		}
		return instance;
	}

	public static <T> T getDAO(Class<?> clazz) {
		DAOManager manager = DaoMap.get(clazz);
		if (manager == null) {
			return findDaoInstance(clazz);
		}
		return (T) manager.getDaoInstance(clazz);
	}

	protected static <T> T findDaoInstance(Class<?> clazz) {
		for (DAOManager manager : ManagerList) {
			T result = manager.getDaoInstance(clazz);
			if (result != null) {
				DaoMap.put(clazz, manager);
				return result;
			}
		}
		throw new RuntimeException("There is no DAO implementation found for class :" + clazz.getName());
	}

	protected DaoManager buildDaoManager(String confFile) {
		DaoManager daoManager = null;
		try {
			Reader reader = Resources.getResourceAsReader(confFile);
			daoManager = DaoManagerBuilder.buildDaoManager(reader);
			reader.close();
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
		return daoManager;
	}
}


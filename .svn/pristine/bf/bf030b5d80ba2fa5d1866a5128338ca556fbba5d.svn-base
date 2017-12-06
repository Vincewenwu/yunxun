package com.vision.edu.platform.common.interceptor.page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeException;
import org.apache.ibatis.type.TypeHandler;
 
 
 
/**
 * 分页拦截器，用于拦截需要进行分页查询的操作，然后对其进行分页处理。 
 * 利用拦截器实现Mybatis分页的原理： 
 * 要利用JDBC对数据库进行操作就必须要有一个对应的Statement对象，Mybatis在执行Sql语句前就会产生一个包含Sql语句的Statement对象，而且对应的Sql语句 
 * 是在Statement之前产生的，所以我们就可以在它生成Statement之前对用来生成Statement的Sql语句下手。在Mybatis中Statement语句是通过RoutingStatementHandler对象的 
 * prepare方法生成的。所以利用拦截器实现Mybatis分页的一个思路就是拦截StatementHandler接口的prepare方法，然后在拦截器方法中把Sql语句改成对应的分页查询Sql语句，之后再调用 
 * StatementHandler对象的prepare方法，即调用invocation.proceed()。 
 * 对于分页而言，在拦截器里面我们还需要做的一个操作就是统计满足当前条件的记录一共有多少，这是通过获取到了原始的Sql语句后，把它改为对应的统计语句再利用Mybatis封装好的参数和设 
 * 置参数的功能把Sql语句中的参数进行替换，之后再执行查询记录数的Sql语句进行总记录数的统计。 
 *
 * @title 
 * @filename PagePlugin.java
 * @author XieFan
 * @date 2017年3月27日 下午8:41:49
 * @version 1.0
 */
@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})  
public class PagePlugin implements Interceptor {

	 //private final Logger logger = LoggerFactory.getLogger(PagePlugin.class);

	    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
	    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
	    private static final ReflectorFactory DEFAULT_REFLECTOR_FACTORY =new DefaultReflectorFactory();
	    private static String pageSqlId = ".*Page"; // mapper.xml中需要拦截的ID(正则匹配)
	    
	    @SuppressWarnings({ "unchecked", "unused" })
		public Object intercept(Invocation invocation) throws Throwable {  
	        
	         StatementHandler statementHandler = (StatementHandler) invocation.getTarget();  
	         MetaObject metaStatementHandler = MetaObject.forObject(statementHandler,  
	         DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY,DEFAULT_REFLECTOR_FACTORY);
	         // 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环  
	         // 可以分离出最原始的的目标类)  
	         while (metaStatementHandler.hasGetter("h")) {  
	             Object object = metaStatementHandler.getValue("h");  
	             metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY,   
	             DEFAULT_OBJECT_WRAPPER_FACTORY,DEFAULT_REFLECTOR_FACTORY);  
	         }
	         // 分离最后一个代理对象的目标类  
	         while (metaStatementHandler.hasGetter("target")) {  
	             Object object = metaStatementHandler.getValue("target");  
	             metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY,   
	             DEFAULT_OBJECT_WRAPPER_FACTORY,DEFAULT_REFLECTOR_FACTORY);  
	         }
	         
	         MappedStatement mappedStatement = (MappedStatement)
	         metaStatementHandler.getValue("delegate.mappedStatement");  
	         // 只重写需要分页的sql语句。通过MappedStatement的ID匹配，默认重写以Page结尾的  
	         //  MappedStatement的sql  
	         BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");  
	         if (mappedStatement.getId().matches(pageSqlId)) {
		         Object parameterObject = boundSql.getParameterObject();
		         String sdf=parameterObject.toString();
		         Map<String,Object> map=(Map<String,Object>)parameterObject;
		         Object pageParam=null;
		         if(map.containsKey("pageParam")){
		        	 pageParam=map.get("pageParam");
		         }else{
		        	 pageParam=null;
		         }
		         if(pageParam instanceof PageParam){
		             if (pageParam == null) {
		                 throw new NullPointerException("parameterObject is null!");
		             } else {
		                 PageParam page = (PageParam)pageParam;
		                 String sql = boundSql.getSql(); 
		                 // 重写sql  
		                 String pageSql = buildPageSql(sql, page);  
		                 metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
		                 metaStatementHandler.setValue("delegate.rowBounds.offset",   
		                 RowBounds.NO_ROW_OFFSET);  
		                 metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
		                 Connection connection = (Connection) invocation.getArgs()[0];  
		                 // 重设分页参数里的总页数等  
		                 setPageParameter(sql, connection, mappedStatement, boundSql, page);  
		             }
		         }  
	         }
	         // 将执行权交给下一个拦截器  
	         return invocation.proceed();  
	     }  
	    
	    private String buildPageSql(String sql, PageParam page) {  
	        if (page != null) {  
	            StringBuilder pageSql = new StringBuilder();  
	                pageSql = buildPageSqlForOracle(sql, page);  
	            return pageSql.toString();  
	        } else {
	            return sql;  
	        }  
	    }  
	    
	    public StringBuilder buildPageSqlForOracle(String sql, PageParam page) {
	        StringBuilder pageSql = new StringBuilder(100);
	        pageSql.append(sql);
	        int pageSize=page.getPageSize();
	        if(pageSize>0){
	        String beginrow =""; 
        	beginrow= String.valueOf((page.getCurrentPage() - 1) * pageSize); 
	        	pageSql.append(" LIMIT ");
	 	        pageSql.append(beginrow);
	 	        pageSql.append(",");
	 	        pageSql.append(pageSize);
	        }
//	        pageSql.append("select * from ( select temp.*, rownum row_id from ( ");  
//	        pageSql.append(sql);  
//	        pageSql.append(" ) temp where rownum <= ").append(endrow);
//	        pageSql.append(") where row_id > ").append(beginrow);
	        return pageSql;  
	    }  
	    
	    /** 
	     * 从数据库里查询总的记录数并计算总页数，回写进分页参数<code>PageParam</code>,这样调用  
	     * 者就可用通过 分页参数<code>PageParam</code>获得相关信息。 
	     *  
	     * @param sql 
	     * @param connection 
	     * @param mappedStatement 
	     * @param boundSql 
	     * @param page 
	     * @throws SQLException 
	     */  
	    private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement,  
	            BoundSql boundSql, PageParam page) throws SQLException {  
	        // 记录总记录数  
	        String countSql = "select count(0) from (" + sql + ") t1";
	        PreparedStatement countStmt = null;  
	        ResultSet rs = null;  
	        try {  
	            countStmt = connection.prepareStatement(countSql);  
	            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
	                    boundSql.getParameterMappings(), boundSql.getParameterObject());
	            
	            setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject()); 
	            rs = countStmt.executeQuery();
	            int totalCount = 0;
	            if (rs.next()) {
	                totalCount = rs.getInt(1);
	            }
	            page.setTotalCount(totalCount);
	            if(page.getPageSize()>0){
	            	int totalPage = totalCount / page.getPageSize() + ((totalCount % page.getPageSize() == 0) ? 0 : 1);  
		            page.setTotalPage(totalPage);
	            }else{
	            	page.setTotalPage(totalCount);
	            }
	            
	        } catch (SQLException e) {  
	            //logger.error("exception", e); 
	        } finally {
	            try {  
	            	if(rs!=null){
	            		rs.close();  
	            	}
	            } catch (SQLException e) 
	            {  
	                //logger.error("exception", e);  
	            }  
	            try {  
	            	if(countStmt!=null){
	                countStmt.close();  
	            	}
	            } catch (SQLException e) {  
	                //logger.error("exception", e);  
	            }  
	        }  
	    }  
	      
	    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,  
	            Object parameterObject) throws SQLException {
	        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);  
	        parameterHandler.setParameters(ps); 
	    }  
	    
	    public Object plugin(Object target) {    
	        if (target instanceof StatementHandler) {  
	            return Plugin.wrap(target, this);
	        } else {
	            return target;
	        }
	    }
	    
	    public void setProperties(Properties properties) {
//	    	pageSqlId = properties.getProperty("pageSqlId");
//			if (Tools.isNotNull(pageSqlId)) {
//				throw new RuntimeException("pageSqlId property is not found!");
//			}
	    }
	    
	    @SuppressWarnings({ "unchecked", "rawtypes" })
		public void setParameters1(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,  
	            Object parameterObject) {  
	        ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId());  
	        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();  
	        if (parameterMappings != null) {  
	          for (int i = 0; i < parameterMappings.size(); i++) {  
	            ParameterMapping parameterMapping = parameterMappings.get(i);  
	            if (parameterMapping.getMode() != ParameterMode.OUT) {  
	              Object value;  
	              String propertyName = parameterMapping.getProperty();  
	              if (boundSql.hasAdditionalParameter(propertyName)) { // issue #448 ask first for additional params  
	                value = boundSql.getAdditionalParameter(propertyName);  
	              } else if (parameterObject == null) {  
	                value = null;  
	              }
//	              else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {  
//	                value = parameterObject;  
//	              } 
	              else {  
	                MetaObject metaObject = mappedStatement.getConfiguration().newMetaObject(parameterObject);  
	                value = metaObject.getValue(propertyName);  
	              }  
	              TypeHandler typeHandler = parameterMapping.getTypeHandler();  
	              JdbcType jdbcType = parameterMapping.getJdbcType();  
	              if (value == null && jdbcType == null) {  
	                jdbcType = mappedStatement.getConfiguration().getJdbcTypeForNull();  
	              }  
	              try {  
	                typeHandler.setParameter(ps,i+1, value, jdbcType); 
	              } catch (TypeException e) {  
	                throw new TypeException("Could not set parameters for mapping: " + parameterMapping + ". Cause: " + e, e);  
	              } catch (SQLException e) {  
	                throw new TypeException("Could not set parameters for mapping: " + parameterMapping + ". Cause: " + e, e);  
	              }  
	            }  
	          }  
	        }  
	      }  

}

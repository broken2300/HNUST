package com.cn.hnust.mongo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.cn.hnust.pojo.CityList;
import com.cn.hnust.pojo.PollutantInfo;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;

@Repository
public class PollutantInfoMapperImpl implements PollutantInfoMapper {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Override
	public int deleteByPrimaryKey(ObjectId id) {
		Query query = new Query();
        Criteria criteria = Criteria.where("_id").is(id);
        query.addCriteria(criteria);
        if(this.mongoTemplate.findAndRemove(query, PollutantInfo.class) != null)
        {
        	return 1;
        }
        else{
        	return 0;
        }
	}

	@Override
	public void insert(PollutantInfo info) {
		this.mongoTemplate.insert(info);
	}

	@Override
	public PollutantInfo selectByPrimaryKey(ObjectId id) {
		
		return this.mongoTemplate.findById(id, PollutantInfo.class, "pollutantInfo");
	}

	/**
	 * update参数为需要修改的key=value形式
	 */
	@Override
	public int updateByPrimaryKey(PollutantInfo info,Update update) {
		Query query = new Query();
        Criteria criteria = Criteria.where("_id").is(info.get_id());
        query.addCriteria(criteria);
        WriteResult result = this.mongoTemplate.updateFirst(query, update, PollutantInfo.class);
        if(result.getN()>1){
        	return 1;
        }
        else{
    		return 0;        	
        }
	}

	@Override
	public List<PollutantInfo> selectByDateAndCity(String date, String city) {
		Query query = new Query();
        Criteria criteria = Criteria.where("time").is(date).andOperator(Criteria.where("city").is(city));
        query.addCriteria(criteria);
		return this.mongoTemplate.find(query, PollutantInfo.class, "pollutantInfo");
	}

	@Override
	public List<PollutantInfo> selectAllByDateAndCity(String startdate, String enddate, String city){
		Query query = new Query();
		Criteria criteria = new Criteria();
		criteria.orOperator(Criteria.where("monitor").is(""),Criteria.where("monitor").exists(false));
        Criteria criteria1 =Criteria.where("time").gte(startdate).lte(enddate).andOperator(Criteria.where("city").regex(city)); 
        query.addCriteria(criteria);
        query.addCriteria(criteria1);
        //query.addCriteria(Criteria.where("time").regex("00:00:00"));
		return this.mongoTemplate.find(query, PollutantInfo.class, "pollutantInfo");
	}

	@Override
	public List<PollutantInfo> getAllCityPollutantInfo(String date) {
		//List<PollutantInfo> Plist = new ArrayList<PollutantInfo>();
		//for(String x:CityList.cities) {
			Query query = new Query();			
			Criteria criteria = //Criteria.where("city").is(x).andOperator(Criteria.where("station").is("").andOperator(Criteria.where("city").is(x)));
			Criteria.where("time").is(date);//.andOperator(Criteria.where("monitor").exists(false));
			query.addCriteria(criteria);
			//query.with(new Sort(new Order(Direction.DESC,"time")));
			//Plist.add((PollutantInfo) this.mongoTemplate.findOne(query, PollutantInfo.class, "pollutantInfo"));
		//}
		List<PollutantInfo>	list = this.mongoTemplate.find(query, PollutantInfo.class, "pollutantInfo");
		for(PollutantInfo x:list) {
			x.setCity(x.getCity().replace("市", ""));
		}
		return list;//Plist;
	}

	@Override
	public List<PollutantInfo> selectAllByDateAndCityToAnalyze(String startdate, String enddate, String city) {
		Query query = new Query();
		Criteria criteria = new Criteria();
		criteria.orOperator(Criteria.where("monitor").is(""),Criteria.where("monitor").exists(false));
        Criteria criteria1 =Criteria.where("time").gte(startdate).lte(enddate).andOperator(Criteria.where("city").regex(city)); 
        query.addCriteria(criteria);
        query.addCriteria(criteria1);
        
		List<PollutantInfo>	tempList = this.mongoTemplate.find(query, PollutantInfo.class, "pollutantInfo");
		List<PollutantInfo> list = new ArrayList<PollutantInfo>();
		for (PollutantInfo pollutantInfo : tempList) {
			
//			System.out.println("testIMPL"+pollutantInfo);
			
			if(pollutantInfo.getTime().contains("00:00:00")){
//				System.out.println("testContains"+pollutantInfo);
				list.add(pollutantInfo);
			}
		}

		return list;
	}

	@Override
	public List<PollutantInfo> selectAllByDateAndMonitorToAnalyze(String startdate, String enddate, String monitor) {
		// TODO Auto-generated method stub
		Query query = new Query();
		Criteria criteria = new Criteria();		
        Criteria criteria1 =Criteria.where("time").gte(startdate).lte(enddate).andOperator(Criteria.where("monitor").regex(monitor)); 
        query.addCriteria(criteria);
        query.addCriteria(criteria1);
        
		List<PollutantInfo>	tempList = this.mongoTemplate.find(query, PollutantInfo.class, "pollutantInfo");
		return null;
	}
	
	
	


}

package plugin.manageqq;

import org.bson.Document;
import org.bson.conversions.Bson;
import plugin.manageqq.database.MongoUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class cave {
    public static void addCave(String content,String user,long id){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        long currentTime = System.currentTimeMillis();
        Date date = new Date(currentTime);
        String dt = df.format(date);
        MongoUtil.createCollection("cave");
        if(!MongoUtil.insertOne("cave",new Document("sender",user).append("content",content).append("senderId",id).append("date",dt))){
            ManageQQ.log.info("失败辣");
        }
    }

    public static Document getCave(){
        Random rd = new Random();
        return Objects.requireNonNull(MongoUtil.find("cave")).get(rd.nextInt(Objects.requireNonNull(MongoUtil.find("cave")).size()));
    }
}

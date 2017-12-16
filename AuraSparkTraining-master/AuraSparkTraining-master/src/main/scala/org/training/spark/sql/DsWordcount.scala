package org.training.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
  * Created by zkpk on 12/16/17.
  */
object DsWordcount {
  def main(args: Array[String]): Unit = {
    var datapath="data/textfile"
    val conf=new SparkConf()
    if(args.length>0)
    {
      datapath=args(0)
    }
    else{
      conf.setMaster("local[1]")

    }
    val spark=SparkSession.builder()
      .appName("dswordcount")
      .config(conf)
      .getOrCreate()
    import spark.implicits._
    val ds=spark.read.textFile(datapath+"/Hamlet.txt").flatMap(_.split("\0|\\s*|\r|\n"))
      .map(x=>(x,1)).toDF("w","c")
    val dsgroup=ds.groupBy("w").count().select("w","count").filter("w!=''")
    dsgroup.orderBy($"count".desc).show(10)
    println("-------------spark-sql----------------")
    ds.createOrReplaceTempView("dswc")
    val dswc=spark.sql("select w,count(*) as sparksqlcount from dswc where w!='' group by w order by sparksqlcount desc")
    dswc.show(10)
    spark.stop()

  }


}

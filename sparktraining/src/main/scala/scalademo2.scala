/**
  * Created by Think on 2017/12/10.
  */
import org.apache.spark._
object scalademo2 {




    def main(args: Array[String]): Unit = {
      val conf=new SparkConf().setAppName("wordcount")
      val sc=new SparkContext(conf)
      val rdd = sc.makeRDD(1 to 10, 2)
      rdd.count()
      rdd.collect()
      rdd.map(_+1)
      val rdd2=rdd.map(x=>x*x)
      rdd2.foreach(println)
      val rdd3=rdd.flatMap(x=>1 to x)
      rdd.collect()
    }

}

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.mllib.tree.impurity.Gini
import org.apache.spark.mllib.util.MLUtils

object DecisionTr extends App {
  val conf = new SparkConf().setAppName("SparkLMlib").setMaster("local[2]")
  val sc = new SparkContext(conf)
  val path = "src/main/resources/iris.scale"
  val data = MLUtils.loadLibSVMFile(sc, path)
  val splits = data.randomSplit(Array(0.73, 0.27))
  val (trainingData, testData) = (splits(0), splits(1))
  val numClasses = 4
  val categoricalFeaturesInfo = Map[Int, Int]()
  val impurity = Gini
  val maxDepth = 9
  val maxBins = 3
  val model = DecisionTree.trainClassifier(trainingData, numClasses, categoricalFeaturesInfo, "gini", maxDepth, maxBins)
  println(model.toDebugString)
  val labelAndPreds = testData.map { point =>
    val prediction = model.predict(point.features)
    (point.label, prediction)
  }
  println(labelAndPreds.count.toDouble / testData.count())
  val testErr = labelAndPreds.filter(r => r._1 != r._2).count.toDouble / testData.count()
  println("Test Error = " + testErr)
  println("Learned classification tree model:\n" + model.toDebugString)
}

package distribution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author luxiaobo
 * @date 2019-05-25  11:15
 */
public class WeightDistribution {

    /**
     * 当前选中的的集合下标
     */
    private static int currentIndex     = -1;
    /**
     * 当前调度的权值
     */
    private static int currentWeight    = 0;
    /**
     * 最大权重
     */
    private static int maxWeight;

    /**
     * 对应需要分配的集合大小
     */
    private static int collectCount;

    /**
     *  待分配的权重集合
     */
    private static List<WeightCollect> weightCollects =  new ArrayList<>();


    /**
     * 集合权重初始化静态块
     * @param
     */
    static {
        weightCollects.add(new WeightCollect(new ArrayList<>(), 1));
        weightCollects.add(new WeightCollect(new ArrayList<>(), 2));
        weightCollects.add(new WeightCollect(new ArrayList<>(), 3));
        weightCollects.add(new WeightCollect(new ArrayList<>(), 4));
        maxWeight = greatestWeight(weightCollects);
        collectCount = weightCollects.size();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入需要调用的次数：");
        int num = scanner.nextInt();
        System.out.println("初始化分配调用次数为：" + num);
        // 按照权重分配规则对的进行输入相应次数的调用
        for (int i = 0; i < num; i++) {
            Object element = new Object();
            //调用分配函数
            allocationElement(element);
        }
        for (WeightCollect weightCollect : weightCollects) {
            List<Object> objectList = weightCollect.getObjectList();
            System.out.println("权重为:" + weightCollect.getWeight()  +  "的集合分配的大小的为:" + objectList.size());
        }
    }

    /**
     * 分配相应元素 （即权重分配函数）
     * @param element
     */
    private static void allocationElement(Object element) {
        while(true){
            currentIndex = (currentIndex + 1) % collectCount;
            if(currentIndex == 0){
                /**
                 * 权重的最大公约数(这里可以默认为1)
                 */
                int maxDivisorWeight = 1;
                currentWeight = currentWeight - maxDivisorWeight;
                if(currentWeight <= 0){
                    currentWeight = maxWeight;
                    if(currentWeight == 0){
                        break;
                    }
                }
            }
            if(weightCollects.get(currentIndex).getWeight() >= currentWeight){
                WeightCollect weightCollect = weightCollects.get(currentIndex);
                weightCollect.getObjectList().add(element);
                break;
            }
        }
    }

    /**
     * 获取最大权重
     * @param collects
     * @return
     */
    private static int greatestWeight(List<WeightCollect> collects){
        int weight = 0;
        for(WeightCollect collect : collects){
            if(weight < collect.getWeight()){
                weight = collect.getWeight();
            }
        }
        return weight;
    }

    /**
     * 构造权重集合静态内部类
     */
    public static class WeightCollect {

        /**
         * 集合
         */
        private List<Object> objectList;

        /**
         * 对应集合权重
         */
        private int weight;

        WeightCollect(List<Object> objectList, int weight) {
            this.objectList = objectList;
            this.weight = weight;
        }

        /**
         * @return
         */
        List<Object> getObjectList() {
            return objectList;
        }

        int getWeight() {
            return weight;
        }

    }

}

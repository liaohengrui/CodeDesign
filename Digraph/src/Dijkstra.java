import java.util.*;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019 /1/13
 */
public class Dijkstra {
    private static int MAX = 10000;
    private String[] attractionsName = {"售票口（起点）", "报春亭", "桃花居", "苏仙湖", "索道入口",
            "全景亭", "白鹿洞", "兰园", "七星关", "三绝碑", "商店", "驿站", "苏仙井", "观景台", "沉香石", "万福山", "苏岭云松", "屈将室", "苏仙观",
            "索道终点"};

    Route[][] routes = new Route[20][20];
    int[][] moneys = new int[20][20];
    int[][] distances = new int[20][20];

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.initAttractions();
        List<int[]> preNodeMoney = dijkstra.dijkstraMoney(0, dijkstra.moneys);
        List<int[]> preNodeDistance = dijkstra.dijkstraDistance(0, dijkstra.distances);
        List<String> listName = new ArrayList<>(Arrays.asList(dijkstra.attractionsName));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("****************************路程优先请按1  价格优先请按2  路程+价格优先请按3****************************");
            String i = scanner.nextLine();
            switch (i) {
                case "1":
                    System.out.println("输入要去的地点");
                    String place = scanner.nextLine();
                    List<List<Integer>> choose = new ArrayList<>();
                    for (int[] preNodeDistanceOne : preNodeDistance) {
                        int index = listName.indexOf(place);
                        List<Integer> list = new ArrayList<>();
                        list.add(index);
                        while (index != 0) {
                            index = preNodeDistanceOne[index];
                            list.add(0, index);
                        }
                        choose.add(list);
                    }
                    removeRepeat(choose);
                    for (List<Integer> list : choose) {
                        StringBuffer buffer = new StringBuffer();
                        for (Integer integer : list) {
                            buffer.append(listName.get(integer));
                            buffer.append("-->");
                        }
                        buffer.delete(buffer.length() - 3, buffer.length());
                        System.out.println(buffer.toString());
                    }
                    break;
                case "2":
                    System.out.println("输入要去的地点");
                    place = scanner.nextLine();
                    choose = new ArrayList<>();
                    for (int[] preNodeDistanceOne : preNodeMoney) {
                        int index = listName.indexOf(place);
                        List<Integer> list = new ArrayList<>();
                        list.add(index);
                        while (index != 0) {
                            index = preNodeDistanceOne[index];
                            list.add(0, index);
                        }
                        choose.add(list);
                    }
                    removeRepeat(choose);
                    for (List<Integer> list : choose) {
                        StringBuffer buffer = new StringBuffer();
                        for (Integer integer : list) {
                            buffer.append(listName.get(integer));
                            buffer.append("-->");
                        }
                        buffer.delete(buffer.length() - 3, buffer.length());
                        System.out.println(buffer.toString());
                    }
                    break;
                case "3":
                    List<Integer> moneys = new ArrayList<>();
                    System.out.println("输入要去的地点");
                    place = scanner.nextLine();
                    choose = new ArrayList<>();
                    for (int[] preNodeDistanceOne : preNodeDistance) {
                        int index = listName.indexOf(place);
                        List<Integer> list = new ArrayList<>();
                        list.add(index);
                        while (index != 0) {
                            index = preNodeDistanceOne[index];
                            list.add(0, index);
                        }
                        choose.add(list);
                    }
                    removeRepeat(choose);
                    for (int j = 0; j < choose.size(); j++) {
                        int money = 0;
                        for (int k = 0; k < choose.get(j).size() - 1; k++) {
                            int place1 = choose.get(j).get(k);
                            int place2 = choose.get(j).get(k + 1);
                            money += dijkstra.routes[place1][place2].price;
                        }
                        moneys.add(money);
                    }
                    int index = moneys.indexOf(Collections.min(moneys));
                    StringBuffer buffer = new StringBuffer();
                    for (Integer integer : choose.get(index)) {
                        buffer.append(listName.get(integer));
                        buffer.append("-->");
                    }
                    buffer.delete(buffer.length() - 3, buffer.length());
                    System.out.println(buffer.toString());
                    break;
                default:
                    System.out.println("输入有误");
            }
        }

    }


    private void initAttractions() {
        System.out.println("初始化20个景点");
        for (String s : attractionsName) {
            System.out.print(s + "   ");
        }
        routes[0][0] = new Route(0, 0);
        routes[0][1] = new Route(10, 500);
        routes[0][2] = new Route(10, 200);
        routes[0][3] = new Route(20, 400);
        routes[0][4] = new Route(150, 700);
        routes[1][5] = new Route(10, 200);
        routes[2][6] = new Route(50, 100);
        routes[3][7] = new Route(60, 500);
        routes[4][19] = new Route(0, 1150);
        routes[5][8] = new Route(60, 400);
        routes[6][9] = new Route(30, 100);
        routes[7][12] = new Route(15, 400);
        routes[8][10] = new Route(125, 150);
        routes[9][11] = new Route(90, 400);
        routes[10][13] = new Route(100, 1500);
        routes[11][15] = new Route(70, 150);
        routes[12][17] = new Route(30, 700);
        routes[19][18] = new Route(50, 50);
        routes[18][17] = new Route(50, 100);
        routes[17][16] = new Route(20, 100);
        routes[16][15] = new Route(100, 300);
        routes[15][14] = new Route(10, 100);
        routes[14][13] = new Route(50, 500);

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[0].length; j++) {
                moneys[i][j] = MAX;
                distances[i][j] = MAX;
                if (routes[i][j] != null) {
                    moneys[i][j] = routes[i][j].price;
                    distances[i][j] = routes[i][j].distance;
                }
            }
        }

    }

    private static void removeRepeat(List<List<Integer>> lists) {
        for (int i = 0; i < lists.size(); i++) {
            for (int j = i + 1; j < lists.size(); j++) {
                List<Integer> aChoose = lists.get(i);
                List<Integer> otherChoose = lists.get(j);
                if (aChoose.size() == otherChoose.size()) {
                    boolean flag = true;
                    for (int k = 0; k < aChoose.size(); k++) {
                        if (!aChoose.get(k).equals(otherChoose.get(k))) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        lists.remove(j);
                    }
                }
            }
        }
    }


    //最短路径
    public List<int[]> dijkstraDistance(int vs, int[][] distances) {
        int size = distances.length;
        int[] prenode = new int[size];
        List<int[]> prenodes = new ArrayList<>();
        prenodes.add(prenode);
        int[] mindist = new int[size];
        boolean[] find = new boolean[size];
        for (int i = 0; i < size; i++) {
            mindist[i] = distances[vs][i];
        }
        int vnear = vs;
        prenode[vs] = vs;
        find[vs] = true;
        for (int j = 1; j < size; j++) {
            int minVal = MAX;
            for (int i = 0; i < size; i++) {
                if (!find[i] && mindist[i] < minVal) {
                    vnear = i;
                    minVal = mindist[i];
                }
            }
            for (int i = 0; i < size; i++) {
                if (!find[i] && (minVal + distances[vnear][i]) <= mindist[i]) {
                    if ((minVal + distances[vnear][i]) == mindist[i]) {
                        int length = prenodes.size();
                        for (int k = 0; k < length; k++) {
                            int[] prenodeNew = prenodes.get(k).clone();
                            prenodeNew[i] = vnear;
                            prenodes.add(prenodeNew);
                        }
                    } else {
                        mindist[i] = distances[vnear][i] + minVal;
                        for (int[] prenodeOld : prenodes) {
                            prenodeOld[i] = vnear;
                        }
                    }
                }
            }
            find[vnear] = true;
        }
        return prenodes;
    }

    //最少花费
    public List<int[]> dijkstraMoney(int vs, int[][] moneys) {
        int size = moneys.length;
        int[] prenode = new int[size];
        List<int[]> prenodes = new ArrayList<>();
        prenodes.add(prenode);
        int[] mindist = new int[size];
        boolean[] find = new boolean[size];
        for (int i = 0; i < size; i++) {
            mindist[i] = moneys[vs][i];
        }
        int vnear = vs;
        prenode[vs] = vs;
        find[vs] = true;
        for (int j = 1; j < size; j++) {
            int minVal = MAX;
            for (int i = 0; i < size; i++) {
                if (!find[i] && mindist[i] < minVal) {
                    vnear = i;
                    minVal = mindist[i];
                }
            }
            for (int i = 0; i < size; i++) {
                if (!find[i] && (minVal + moneys[vnear][i]) <= mindist[i]) {
                    if ((minVal + moneys[vnear][i]) == mindist[i]) {
                        int length = prenodes.size();
                        for (int k = 0; k < length; k++) {
                            int[] prenodeNew = prenodes.get(k).clone();
                            prenodeNew[i] = vnear;
                            prenodes.add(prenodeNew);
                        }
                    } else {
                        mindist[i] = moneys[vnear][i] + minVal;
                        for (int[] prenodeOld : prenodes) {
                            prenodeOld[i] = vnear;
                        }
                    }
                }
            }
            find[vnear] = true;
        }
        return prenodes;
    }

    class Route {
        int price;
        int distance;

        public Route(int price, int distance) {
            this.price = price;
            this.distance = distance;
        }
    }
}

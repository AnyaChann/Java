package main.collection1;

import java.util.*;

public class CollectionPerformanceTest1 {

    private static final int ELEMENTS = 100000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. So Sánh Hiệu Suất List (ArrayList, LinkedList)");
            System.out.println("2. So Sánh Hiệu Suất Set (HashSet, LinkedHashSet, TreeSet)");
            System.out.println("3. So Sánh Hiệu Suất Map (HashMap, LinkedHashMap, TreeMap)");
            System.out.println("4. So Sánh Hiệu Suất Queue (LinkedList, PriorityQueue)");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nĐang kiểm tra hiệu suất List...");
                    testListPerformance(new ArrayList<>(), "ArrayList");
                    testListPerformance(new LinkedList<>(), "LinkedList");
                    break;
                case 2:
                    System.out.println("\nĐang kiểm tra hiệu suất Set...");
                    testSetPerformance(new HashSet<>(), "HashSet");
                    testSetPerformance(new LinkedHashSet<>(), "LinkedHashSet");
                    testSetPerformance(new TreeSet<>(), "TreeSet");
                    break;
                case 3:
                    System.out.println("\nĐang kiểm tra hiệu suất Map...");
                    testMapPerformance(new HashMap<>(), "HashMap");
                    testMapPerformance(new LinkedHashMap<>(), "LinkedHashMap");
                    testMapPerformance(new TreeMap<>(), "TreeMap");
                    break;
                case 4:
                    System.out.println("\nĐang kiểm tra hiệu suất Queue...");
                    testQueuePerformance(new LinkedList<>(), "LinkedList Queue");
                    testQueuePerformance(new PriorityQueue<>(), "PriorityQueue");
                    break;
                case 5:
                    System.out.println("Thoát...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }

            if (choice != 5) {
                System.out.print("Bạn có muốn tiếp tục không? (y/n): ");
                String continueChoice = scanner.next();
                if (!continueChoice.equalsIgnoreCase("y")) {
                    break;
                }
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void testListPerformance(List<Integer> list, String type) {
        long startTime, endTime;

        // Thêm phần tử
        startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            list.add(i);
        }
        endTime = System.nanoTime();
        System.out.println(type + " thêm: " + (endTime - startTime) + " ns");

        // Lấy phần tử
        startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            list.get(i);
        }
        endTime = System.nanoTime();
        System.out.println(type + " lấy: " + (endTime - startTime) + " ns");

        // Xóa phần tử
        startTime = System.nanoTime();
        for (int i = ELEMENTS - 1; i >= 0; i--) {
            list.remove(i);
        }
        endTime = System.nanoTime();
        System.out.println(type + " xóa: " + (endTime - startTime) + " ns");

        // Nhận xét hiệu suất
        System.out.println("Tóm tắt hiệu suất của " + type + ":");
        System.out.println("Thêm: Nhanh cho ArrayList, chậm hơn cho LinkedList do phải dịch chuyển các phần tử.");
        System.out.println("Lấy: Nhanh cho ArrayList, chậm hơn cho LinkedList do phải duyệt qua các phần tử.");
        System.out.println("Xóa: Chậm cho ArrayList do phải dịch chuyển các phần tử, nhanh hơn cho LinkedList.");
    }

    private static void testSetPerformance(Set<Integer> set, String type) {
        long startTime, endTime;

        // Thêm phần tử
        startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            set.add(i);
        }
        endTime = System.nanoTime();
        System.out.println(type + " thêm: " + (endTime - startTime) + " ns");

        // Kiểm tra phần tử
        startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            set.contains(i);
        }
        endTime = System.nanoTime();
        System.out.println(type + " kiểm tra: " + (endTime - startTime) + " ns");

        // Xóa phần tử
        startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            set.remove(i);
        }
        endTime = System.nanoTime();
        System.out.println(type + " xóa: " + (endTime - startTime) + " ns");

        // Nhận xét hiệu suất
        System.out.println("Tóm tắt hiệu suất của " + type + ":");
        System.out.println("Thêm: Nhanh cho HashSet và LinkedHashSet, chậm hơn cho TreeSet do phải sắp xếp.");
        System.out.println("Kiểm tra: Nhanh cho HashSet và LinkedHashSet, chậm hơn cho TreeSet.");
        System.out.println("Xóa: Nhanh cho HashSet và LinkedHashSet, chậm hơn cho TreeSet.");
    }

    private static void testMapPerformance(Map<Integer, Integer> map, String type) {
        long startTime, endTime;

        // Đặt phần tử
        startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            map.put(i, i);
        }
        endTime = System.nanoTime();
        System.out.println(type + " đặt: " + (endTime - startTime) + " ns");

        // Lấy phần tử
        startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            map.get(i);
        }
        endTime = System.nanoTime();
        System.out.println(type + " lấy: " + (endTime - startTime) + " ns");

        // Xóa phần tử
        startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            map.remove(i);
        }
        endTime = System.nanoTime();
        System.out.println(type + " xóa: " + (endTime - startTime) + " ns");

        // Nhận xét hiệu suất
        System.out.println("Tóm tắt hiệu suất của " + type + ":");
        System.out.println("Đặt: Nhanh cho HashMap và LinkedHashMap, chậm hơn cho TreeMap do phải sắp xếp.");
        System.out.println("Lấy: Nhanh cho HashMap và LinkedHashMap, chậm hơn cho TreeMap.");
        System.out.println("Xóa: Nhanh cho HashMap và LinkedHashMap, chậm hơn cho TreeMap.");
    }

    private static void testQueuePerformance(Queue<Integer> queue, String type) {
        long startTime, endTime;

        // Thêm phần tử
        startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            queue.add(i);
        }
        endTime = System.nanoTime();
        System.out.println(type + " thêm: " + (endTime - startTime) + " ns");

        // Peek phần tử
        startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            queue.peek();
        }
        endTime = System.nanoTime();
        System.out.println(type + " peek: " + (endTime - startTime) + " ns");

        // Xóa phần tử
        startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            queue.poll();
        }
        endTime = System.nanoTime();
        System.out.println(type + " poll: " + (endTime - startTime) + " ns");

        // Nhận xét hiệu suất
        System.out.println("Tóm tắt hiệu suất của " + type + ":");
        System.out.println("Thêm: Nhanh cho LinkedList, chậm hơn cho PriorityQueue do phải sắp xếp.");
        System.out.println("Peek: Nhanh cho cả LinkedList và PriorityQueue.");
        System.out.println("Poll: Nhanh cho LinkedList, chậm hơn cho PriorityQueue do phải sắp xếp.");
    }
}
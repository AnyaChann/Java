
# List Interface

The List interface is a part of the collection interface that allows us to store an ordered collection of objects.

- **List**: An ordered collection of elements. A List can contain duplicate elements.
- **Set**: An unordered collection of elements that does not allow duplicates.
- **Map**: Stores elements in key-value pairs and does not allow duplicate keys.
- **Queue**: Stores elements in a FIFO (first in, first out) manner.

## ArrayList

ArrayList is an implementation of the List interface that allows duplicate elements and maintains the order of insertion.

- **Advantages**: Fast search operations.
- **Disadvantages**: When adding or removing elements, the entire list may need to be restructured.

## LinkedList

LinkedList is an implementation of the List interface that allows duplicate elements and maintains the order of insertion.

- **Advantages**: When adding, updating, or deleting elements, only the adjacent elements are affected.
- **Disadvantages**: Slower than ArrayList for search operations.
- **Use Case**: Suitable when frequent modifications to the list are required.

## Exercises

Each class should implement a program with the following functionalities: ADD, EDIT, DELETE.

## ATM

Giả sử viết 1 chương trình thực thi giao dịch ATM system hoặc giao dịch Internet Banking chúng ta sẽ phải sử dụng các Collection API ntn?

### 1. `Map<String, Account> accountMap = new HashMap<>();`

- **Chức năng**: Lưu trữ ds tài khoản, tra cứu nhanh theo stk (accountNumber)
- **HashMap**: Có thời gian truy suất phần tử trung bình là O(1) phù hợp cho thao tác tìm kiếm, cập nhật.

### 2. `List<Transaction> transactionList = new ArrayList<>();`

- **Chức năng**: Lưu toàn bộ lịch sử giao dịch
- **ArrayList**: Cho phép duyệt và thêm cuối nhanh tb là O(1). Không dùng cho thao tác: chèn, xóa, sửa ở giữa... thường xuyên.

### 3. `Set<String> blackListAccounts = HashSet<>();`

- **Chức năng**: Lưu ds các tài khoản bị khóa, (blackList), cần không trùng lặp và kiểm tra thành viên nhanh.
- **HashSet**: cho phép kiểm tra (Contains) tb O(1). Rất thích hợp tìm kiếm, ngăn chặn.

### 4. `Queue<Transaction> transactionQueue = new LinkedList<>();`

- **Chức năng**: Minh họa mô hình FIFO(First In First Out) cho phép giao dịch diễn ra lần lượt.
- **LinkedList**: thực hiện tốt cấu trúc queue.

### 5. `Set<String> storedAccountNumbers = new Tress<>();`

- **Chức năng**: Lưu các accountNumber dưới dạng sắp xếp(theo tt tăng dần)

### 6. `PriorityQueue<Account> accountByBalance = new PriorityQueue<>(Comparator);`

- **Chức năng**: Lưu các Account theo độ ưu tiên(vd: sắp xếp giảm dần theo số dư), giúp ta biết ngay tài khoản có số dư lớn nhất...
- **PriorityQueue**: cho phép lấy pt có độ ưu tiên cao nhất trong O(log n).


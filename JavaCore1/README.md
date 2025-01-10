I. List Interface
List interface: Là interface của collection interface chúng ta có thể lưu trữ tập hợp các đối tượng có thứ tự
-List: Là một danh sách các phần tử có thứ tự. Líst chứa 2 hoặc nhiều các pt giống nhau
-Set: là một danh sách các phần tử không có thứ tự và ko cho phép các pt trùng nhau
-Map: lưu trữ các phần tử theo cặp giá trị (Key và Value) ko cho phép key trùng nhau
-Queue: lưu các phần tử theo công thức FIFO (first in first out)

ArrayList: Các bản ghi được sắp xếp và cho phép trùng lặp
Ưu: Tốc độ tìm kiếm nhanh
Nhược: Khi thêm hoặc xóa bản ghi, cả danh sách sẽ buộc phải sắp xếp lại
=> 

LinkedList 
Ưu: Khi Thêm/Sửa/Xóa chỉ ảnh hưởng đến bản ghi trước và sau
Nhược: Tốc độ chậm hơn ArrayList ?
=> Phù hợp khi các bản ghi đc thay đổi thường xuyên

BTTVN mỗi class một chương trình dưới dạng ADD/EDIT/DELETE
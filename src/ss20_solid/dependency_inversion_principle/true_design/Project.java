package ss20_solid.dependency_inversion_principle.true_design;

/**
 * Lúc này chúng ta muốn thay đổi code ở backend hay fontend thì chỉ cần tạo class khác triển khai
 * Interface IDevelop mà không cần sửa code của bất kỳ module nào
 * lúc khởi tạo Project để sử dụng chúng ta chỉ cần truyền vào class cần sử dụng
 */
class Project {
    //Project phụ thuộc vào IDevelop(abstraction)
    private IDevelop iDevelop;

    Project(IDevelop iDevelop) {
        this.iDevelop = iDevelop;
    } // Nếu truyền vào method là 1 dối tượng backend

    void build(){
        iDevelop.develop();
    }

}

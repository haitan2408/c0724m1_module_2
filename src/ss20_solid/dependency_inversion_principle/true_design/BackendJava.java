package ss20_solid.dependency_inversion_principle.true_design;

/**
 * Backend phụ thuộc vào IDevelop(abstraction)
 */
class BackendJava implements IDevelop{

    @Override
    public void develop() {
        this.codeJava();
    }

    private void codeJava(){
        System.out.println("Sử dụng code Java xây dựng Backend");
    }

}

package ss20_solid.dependency_inversion_principle.true_design;

public class Main {
        public static void main(String[] args) {
        IDevelop backend = new BackendJava();

        Project projectBackend = new Project(backend);

        Frontend frontend = new Frontend();

        Project projectFrontend = new Project(frontend);

        projectBackend.build();
        projectFrontend.build();

        BackendPHP backendPHP = new BackendPHP();
        Project projectPhp = new Project(backendPHP);
        projectPhp.build();
    }
}

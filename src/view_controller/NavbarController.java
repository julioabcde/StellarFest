package view_controller;

import main.Session;
import view.HomeView;
import view.LoginView;
import view.ManageVendorView;

public class NavbarController {
    private static NavbarController instance;
    ViewController vc;

    private NavbarController() {
        this.vc = ViewController.getInstance(null);
    }
    
    public static NavbarController getInstance() {
        if (instance == null) {
            instance = new NavbarController();
        }
        return instance;
    }

    public void navigateTo(String targetLocation) {
        System.out.println("Navigating to: " + targetLocation);

        if (targetLocation == null || targetLocation.isEmpty()) {
            System.out.println("Error: Target location is null or empty.");
            return;
        }

        // Menangani navigasi ke lokasi tertentu berdasarkan target
        switch (targetLocation) {
            case "HomePage":
                vc.navigateToUserHome();
                break;
            case "ManageProduct":
                vc.navigateToVendor();
                break;
            case "Logout":
            	vc.navigateToLogin();
                break;
            default:
                System.out.println("Error: Unknown location -> " + targetLocation);
        }
    }
}

package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import main.Session;
import view_controller.NavbarController;

public class NavbarView extends MenuBar {
    private Menu menu;
    private MenuItem homePage, manageProduct, manageEvents, viewInvitations, logout;
    private NavbarController navbarController;

    public NavbarView() {
        navbarController = NavbarController.getInstance();
        init();
        setComponent();
        setAction();
    }

    private void init() {
        menu = new Menu("Menu");
        homePage = new MenuItem("Home Page");
        manageProduct = new MenuItem("Manage Product");
        manageEvents = new MenuItem("Manage Events");
        viewInvitations = new MenuItem("View Invitations");
        logout = new MenuItem("Logout");
    }

    private void setComponent() {
        getMenus().add(menu);
        String userRole = Session.getInstance().getUserSession().getUser_role();
        switch (userRole) {
            case "Admin":
                menu.getItems().addAll(homePage, manageEvents, logout);
                break;
            case "Vendor":
                menu.getItems().addAll(homePage, manageProduct, logout);
                break;
            case "Guest":
                menu.getItems().addAll(homePage, logout);
                break;
            case "Event Organizer":
                menu.getItems().addAll(homePage, manageEvents, logout);
                break;
            default:
                menu.getItems().add(logout);
        }
    }

    private void setAction() {
        homePage.setOnAction(e -> navbarController.navigateTo("HomePage"));
        manageProduct.setOnAction(e -> navbarController.navigateTo("ManageProduct"));
        manageEvents.setOnAction(e -> navbarController.navigateTo("ManageEvents"));
        viewInvitations.setOnAction(e -> navbarController.navigateTo("ViewInvitations"));
        logout.setOnAction(e -> navbarController.navigateTo("Logout"));
    }
}

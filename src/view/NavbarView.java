package view;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class NavbarView extends MenuBar{
	public static String CURRENT_LOCATION;
	
	Menu menu;
	MenuItem homePage;
	MenuItem ManageProduct;
	MenuItem logOut;
	
	private void init() {
		menu = new Menu("Admin");
		homePage = new MenuItem("View HomePage");
		ManageProduct = new MenuItem("Manage Product");
		logOut = new MenuItem("Logout");
	}
	
	private void setComponent() {
		getMenus().add(menu);
		menu.getItems().addAll(homePage,ManageProduct,logOut);
	}
	
	private void setAction() {
		homePage.setOnAction(e -> {
			if(!CURRENT_LOCATION.equals("HomePage")) new HomeView();
		});
//		ManageProduct.setOnAction(e -> {
//			if(!CURRENT_LOCATION.equals("Manage Product")) new 
//		});
	}
	
	 public NavbarView() {
	        init();
	        setComponent();
	        setAction();
	    }
}

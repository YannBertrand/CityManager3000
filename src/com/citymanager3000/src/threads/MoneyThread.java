/**
 * 
 */
package com.citymanager3000.src.threads;

import com.citymanager3000.gui.BatimentView;
import com.citymanager3000.gui.panels.GamePanel;
import com.citymanager3000.src.Configuration;
import com.citymanager3000.src.Game;

/**
 * @author Yann Bertrand
 *
 */
public class MoneyThread extends Thread {
	private static double money_per_month;
	
	/**
	 * 
	 */
	public MoneyThread() {
		// TODO Auto-generated constructor stub
		setMoneyPerMonth(0);
	}

	public void run() {
		while(true) {
			this.calculateMoneyOnNewMonth();
			this.updateMoneyOnInfoTab();
			System.out.println("");
			System.out.println("------------------------------");
			System.out.println(" - Nouveau mois : $"+Game.money+" - ");
			System.out.println("------------------------------");
			System.out.println("");
			try {
				// pause
				Thread.sleep(Configuration.MONTH_DURATION);
			}
			catch (InterruptedException ex) {}
		}
	}
	
	public void calculateMoneyOnNewMonth() {
		Game.money = Game.money + MoneyThread.getMoneyPerMonth();
	}
	
	public static void calculateNewMoneyPerMonth(BatimentView batiment_view) {
		MoneyThread.setMoneyPerMonth(MoneyThread.getMoneyPerMonth()+batiment_view.getBatiment().getBeneficeParMois());
	}
	
	public void updateMoneyOnInfoTab() {
		GamePanel.getMoneyLabel().setText("Argent restant : $"+Double.toString(Game.money));
	}

	public static double getMoneyPerMonth() {
		return money_per_month;
	}

	public static void setMoneyPerMonth(double money_per_month) {
		MoneyThread.money_per_month = money_per_month;
	}
}

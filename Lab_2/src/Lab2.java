/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f_desgr
 */
public class Lab2 {
    public static void main(String args[]){
        part1Demo();
        part2Demo();
    }
    
    public static void part1Demo(){
        ProductionWorker emp = new ProductionWorker("Jacob", "001-A","1/1/2016",1, 5);
        System.out.println(emp);
        
    }
    
    public static void part2Demo(){
        TeamLeader tl = new TeamLeader("Marc","001-B","3/5/209",2, 20, 5000.87, 50, 30);
        System.out.println(tl);
    }
}

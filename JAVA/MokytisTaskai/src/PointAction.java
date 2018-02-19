import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PointAction {

    static private List<Point> taskai = new ArrayList<>();


    public void printTaskus() {
        if (taskai.size() == 0) {
            throw new RuntimeException("Sarasas tuscias");
        }
        for (Point item : taskai) {
            System.out.println(taskai.indexOf(item) + ") " + item.getName() + " (" + item.getX() + ") (" + item.getY() + ")");
        }
    }

    public void pridetiTaska(String name, int x, int y) {
        Point point = new Point(name, x, y);
        taskai.add(point);

    }

    public void istrintiTaska(int pIndex) {
        taskai.remove(pIndex);
    }

    public double skaiciuotiAtstumaTarpTasku(int pIndex1, int pIndex2) {
        Point p1 = taskai.get(pIndex1);
        Point p2 = taskai.get(pIndex2);
        return Math.hypot((p1.getX() - p2.getX()), (p1.getY() - p2.getY()));

    }

    public String kurisKetvirtis(int pIndex) {
        Point p = taskai.get(pIndex);
        if (p.getX() > 0 && p.getY() > 0) {
            return "pirmame ketvirtyje";
        }
        if (p.getX() > 0 && p.getY() < 0) {
            return "ketvirtame ketvirtyje";
        }
        if (p.getX() < 0 && p.getY() < 0) {
            return "treciame ketvirtyje";
        }
        if (p.getX() < 0 && p.getY() > 0) {
            return "antrame ketvirtyje";
        }
        return "Koordinaciu pradzios taske";
    }

    public String ketvirciuLyginimas(int pIndex1, int pIndex2) {
        if (kurisKetvirtis(pIndex1).equals(kurisKetvirtis(pIndex2))) {
            return "Taskai yra tame pačiame ketviryje";
        }
        return "Taskai yra skirtinguose ketvirčiuose";
    }
    public void saveTaskusFile(){
        try{
            File file = new File("taskai.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for(Point p :taskai){
                bw.write(p.getName()+ " (" + p.getX() + ") (" + p.getY() + ")");
                bw.newLine();
            }
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}


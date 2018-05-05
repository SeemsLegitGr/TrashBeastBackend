package gr.seemslegit.trashbeastbackend.Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static long totalDistance;
    public static long currentDistance=100;
    public static long nextDistance;

    public static Node currentNode;
    public static Node nextNode;

    public static void main(String[] args) {

        Random random = new Random();

        //set Nodes
        Node serres = new Node("Serres");
        Node provatas = new Node("Provatas");
        Node mitrousi = new Node("Mitrousi");
        Node skoutari = new Node("Skoutari");
        Node aKamila = new Node("A_Kamila");
        Node kKamila = new Node("K_Kamila");
        Node koumaria = new Node("Koumaria");
        Node adelfiko = new Node("Adelfiko");
        Node peponia = new Node("Peponia");
        Node agEleni = new Node("Ag_Eleni");

        //set neighbourhoods
        List<Node> nodeImporter = new ArrayList<>();

        nodeImporter.add(provatas);
        nodeImporter.add(mitrousi);
        nodeImporter.add(skoutari);
        serres.setHood(nodeImporter);

        nodeImporter.clear();

        nodeImporter.add(serres);
        nodeImporter.add(aKamila);
        provatas.setHood(nodeImporter);

        nodeImporter.clear();

        nodeImporter.add(serres);
        nodeImporter.add(aKamila);
        nodeImporter.add(koumaria);
        nodeImporter.add(kKamila);
        mitrousi.setHood(nodeImporter);

        nodeImporter.clear();

        nodeImporter.add(provatas);
        nodeImporter.add(mitrousi);
        nodeImporter.add(koumaria);
        aKamila.setHood(nodeImporter);

        nodeImporter.clear();

        nodeImporter.add(serres);
        nodeImporter.add(kKamila);
        nodeImporter.add(peponia);
        nodeImporter.add(agEleni);
        skoutari.setHood(nodeImporter);

        nodeImporter.clear();

        nodeImporter.add(mitrousi);
        nodeImporter.add(skoutari);
        nodeImporter.add(koumaria);
        kKamila.setHood(nodeImporter);

        nodeImporter.clear();

        nodeImporter.add(aKamila);
        nodeImporter.add(mitrousi);
        nodeImporter.add(kKamila);
        nodeImporter.add(adelfiko);
        koumaria.setHood(nodeImporter);

        nodeImporter.clear();

        nodeImporter.add(skoutari);
        nodeImporter.add(peponia);
        agEleni.setHood(nodeImporter);

        nodeImporter.clear();

        nodeImporter.add(skoutari);
        nodeImporter.add(agEleni);
        nodeImporter.add(adelfiko);
        peponia.setHood(nodeImporter);

        nodeImporter.clear();

        nodeImporter.add(koumaria);
        nodeImporter.add(peponia);
        adelfiko.setHood(nodeImporter);

        nodeImporter.clear();

        //set Paths
        Path serProv = new Path(serres, provatas, (long) 15.1);
        Path serMitr = new Path(serres, mitrousi, (long) 9.4);
        Path serSkout = new Path(serres, skoutari, (long) 9.1);
        Path provAKami = new Path(provatas, aKamila, (long) 12.4);
        Path mitrAKami = new Path(mitrousi, aKamila, (long) 3.1);
        Path mitrKKami = new Path(mitrousi, kKamila, (long) 7);
        Path mitrKouma = new Path(mitrousi, koumaria, (long) 5.5);
        Path skoutKKami = new Path(skoutari, kKamila, (long) 3.2);
        Path skoutPepo = new Path(skoutari, peponia, (long) 4.5);
        Path skoutAgEleni = new Path(skoutari, agEleni, (long) 4.6);
        Path kKamiKouma = new Path(kKamila, koumaria, (long) 5.7);
        Path aKamiKouma = new Path(aKamila, koumaria, (long) 6.3);
        Path koumaAdel = new Path(koumaria, adelfiko, (long) 2.5);
        Path pepoAdel = new Path(peponia, adelfiko, (long) 6.8);
        Path agEleniPepo = new Path(agEleni, peponia, (long) 4.7);


        //set every path to point to its nodes
        List<Path> pathImporter = new ArrayList<>();

        pathImporter.add(serMitr);
        pathImporter.add(serProv);
        pathImporter.add(serSkout);
        serres.setPaths(pathImporter);

        pathImporter.clear();

        pathImporter.add(provAKami);
        pathImporter.add(serProv);
        provatas.setPaths(pathImporter);

        pathImporter.clear();

        pathImporter.add(mitrAKami);
        pathImporter.add(mitrKKami);
        pathImporter.add(mitrKouma);
        pathImporter.add(serMitr);
        mitrousi.setPaths(pathImporter);

        pathImporter.clear();

        pathImporter.add(skoutAgEleni);
        pathImporter.add(skoutKKami);
        pathImporter.add(skoutPepo);
        pathImporter.add(serSkout);
        skoutari.setPaths(pathImporter);

        pathImporter.clear();

        pathImporter.add(aKamiKouma);
        pathImporter.add(provAKami);
        pathImporter.add(mitrAKami);
        aKamila.setPaths(pathImporter);

        pathImporter.clear();


        //logic
        List<Node> nodesPassed = new ArrayList<>();

        List<Node> nodesNotPassed = new ArrayList<>();
        nodesNotPassed.add(serres);
        nodesNotPassed.add(provatas);
        nodesNotPassed.add(mitrousi);
        nodesNotPassed.add(skoutari);
        nodesNotPassed.add(aKamila);
        nodesNotPassed.add(kKamila);
        nodesNotPassed.add(koumaria);
        nodesNotPassed.add(peponia);
        nodesNotPassed.add(agEleni);
        nodesNotPassed.add(adelfiko);

        Route route = new Route(nodesPassed, nodesNotPassed);

        currentNode = serres;
        nextNode = null;

        for(int i=0; i<100; i++) {
            while(nodesNotPassed.size()<10) {
                nextNode = currentNode.getHood().get(random.nextInt(currentNode.getHood().size()));
                nodesPassed.add(nextNode);
                nodesNotPassed.remove(nextNode);
                for(Node node: nodesPassed) {
                    while(!nextNode.equals(node)) {
                        currentNode = nextNode;
                    }
                }
            }
        }


        System.out.println();

    }
}


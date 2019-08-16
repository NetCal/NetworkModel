package org.networkcalculus.dnc.model.ethernet;

import org.junit.jupiter.api.Test;

class EthernetNetworkModelTest {

    @Test
    void test() {
        // Creating network
        EthernetNetwork network = EthernetNetwork.valueOf("ExampleNetwork", 100e6);

        // Creating devices
        EndSystem es1 = network.addEndSystem("ES1");
        es1.setInternalLatency(0.0);
        NetworkInterface es1p1 = es1.addNetworkInterface("es1p1");

        EndSystem es2 = network.addEndSystem("ES2");
        es2.setInternalLatency(0.0);
        NetworkInterface es2p1 = es2.addNetworkInterface("es2p1");

        EndSystem es3 = network.addEndSystem("ES3");
        es3.setInternalLatency(0.0);
        NetworkInterface es3p1 = es3.addNetworkInterface("es3p1");

        EndSystem es4 = network.addEndSystem("ES4");
        es4.setInternalLatency(0.0);
        NetworkInterface es4p1 = es4.addNetworkInterface("es4p1");

        EndSystem es5 = network.addEndSystem("ES5");
        es5.setInternalLatency(0.0);
        NetworkInterface es5p1 = es5.addNetworkInterface("es5p1");

        EndSystem es6 = network.addEndSystem("ES6");
        es6.setInternalLatency(0.0);
        NetworkInterface es6p1 = es6.addNetworkInterface("es6p1");

        EndSystem es7 = network.addEndSystem("ES7");
        es7.setInternalLatency(0.0);
        NetworkInterface es7p1 = es7.addNetworkInterface("es7p1");

        EndSystem es8 = network.addEndSystem("ES8");
        es8.setInternalLatency(0.0);
        NetworkInterface es8p1 = es8.addNetworkInterface("es8p1");

        Switch sw1 = network.addSwitch("SW1");
        sw1.setInternalLatency(16e-6);
        NetworkInterface sw1p1 = sw1.addNetworkInterface("sw1p1");
        NetworkInterface sw1p2 = sw1.addNetworkInterface("sw1p2");
        NetworkInterface sw1p3 = sw1.addNetworkInterface("sw1p3");

        PhysicalLink es1sw1 = network.addPhysicalLink(es1p1, sw1p1);
        PhysicalLink es2sw1 = network.addPhysicalLink(es2p1, sw1p2);

        Switch sw2 = network.addSwitch("SW2");
        sw2.setInternalLatency(16e-6);
        NetworkInterface sw2p1 = sw2.addNetworkInterface("sw2p1");
        NetworkInterface sw2p2 = sw2.addNetworkInterface("sw2p2");
        NetworkInterface sw2p3 = sw2.addNetworkInterface("sw2p3");
        PhysicalLink es3sw2 = network.addPhysicalLink(es3p1, sw2p1);

        Switch sw3 = network.addSwitch("SW3");
        sw3.setInternalLatency(16e-6);
        NetworkInterface sw3p1 = sw3.addNetworkInterface("sw3p1");
        NetworkInterface sw3p2 = sw3.addNetworkInterface("sw3p2");
        NetworkInterface sw3p3 = sw3.addNetworkInterface("sw3p3");
        NetworkInterface sw3p4 = sw3.addNetworkInterface("sw3p4");
        PhysicalLink sw1sw3 = network.addPhysicalLink(sw1p3, sw3p1);
        PhysicalLink sw2sw3 = network.addPhysicalLink(sw2p2, sw3p2);
        PhysicalLink sw3es5 = network.addPhysicalLink(sw3p3, es5p1);
        PhysicalLink sw3es6 = network.addPhysicalLink(sw3p4, es6p1);

        Switch sw4 = network.addSwitch("SW4");
        sw4.setInternalLatency(16e-6);
        NetworkInterface sw4p1 = sw4.addNetworkInterface("sw4p1");
        NetworkInterface sw4p2 = sw4.addNetworkInterface("sw4p2");
        PhysicalLink es4sw4 = network.addPhysicalLink(es4p1, sw4p1);

        Switch sw5 = network.addSwitch("SW5");
        sw5.setInternalLatency(16e-6);
        NetworkInterface sw5p1 = sw5.addNetworkInterface("sw5p1");
        NetworkInterface sw5p2 = sw5.addNetworkInterface("sw5p2");
        NetworkInterface sw5p3 = sw5.addNetworkInterface("sw5p3");
        NetworkInterface sw5p4 = sw5.addNetworkInterface("sw5p4");
        PhysicalLink sw2sw5 = network.addPhysicalLink(sw2p3, sw5p1);
        PhysicalLink sw4sw5 = network.addPhysicalLink(sw4p2, sw5p2);
        PhysicalLink sw5es7 = network.addPhysicalLink(sw5p3, es7p1);
        PhysicalLink sw5es8 = network.addPhysicalLink(sw5p4, es8p1);

        // VL1
        VirtualLink vl1 = network.addVirtualLink("VL1", 1e-1, Priority.LOW, 1000);
        vl1.addPath(es1sw1, sw1sw3, sw3es5);
        
        // VL2
        VirtualLink vl2 = network.addVirtualLink("VL2", 1e-1, Priority.LOW, 1000);
        vl2.addPath(es2sw1, sw1sw3, sw3es6);
        
        // VL3
        VirtualLink vl3 = network.addVirtualLink("VL3", 5e-2, Priority.LOW, 1000);
        vl3.addPath(es3sw2, sw2sw3, sw3es6);
        vl3.addPath(es3sw2, sw2sw5, sw5es7);
        
        // VL4
        VirtualLink vl4 = network.addVirtualLink("VL4", 3e-2, Priority.LOW, 1000);
        vl4.addPath(es3sw2, sw2sw5, sw5es7);
      
        // VL5
        VirtualLink vl5 = network.addVirtualLink("VL5", 3e-1, Priority.LOW, 1000);
        vl5.addPath(es4sw4, sw4sw5, sw5es7);
        
        // VL6
        VirtualLink vl6 =network.addVirtualLink("VL6", 5e-2, Priority.LOW, 1000);
        vl6.addPath(es4sw4, sw4sw5, sw5es8);
    
    }

}

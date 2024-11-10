package ru.globux.test.net;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NetworkInterfaceTest {

    public static void main(String[] args) {

        byte[] bt = {2, 6, 2, 10, 15};
        Stream.of(bt).forEach(x -> System.out.println(x.getClass() + "\\n"));
        Supplier<List<String>> sup = ArrayList::new;
        List<String> list = sup.get();
        IntFunction<String[]> func = value -> new String[value];
        String[] s = func.apply(2);


        try {
            Enumeration<NetworkInterface> niEnum = NetworkInterface.getNetworkInterfaces();
            Iterator<NetworkInterface> it = niEnum.asIterator();
            while(it.hasNext()) {
                NetworkInterface ni = it.next();
                System.out.println("Index: " + ni.getIndex());
                System.out.println("DisplayName: " + ni.getDisplayName());
                System.out.println("Name: " + ni.getName());

                System.out.println("InterfaceAddresses:");
                ni.getInterfaceAddresses().stream().forEach( ifa -> {
                    System.out.println("  " + ifa.getNetworkPrefixLength());
                    if (ifa.getAddress() != null) {
                        String hostAddress = ifa.getAddress().getHostAddress();
                        String canonicalHostName = ifa.getAddress().getCanonicalHostName();
                        String hostName = ifa.getAddress().getHostName();
                        System.out.println("     " + hostAddress + " " + hostName + " " + canonicalHostName);
                    }

                    if (ifa.getBroadcast() != null) {
                        String broadHA = ifa.getBroadcast().getHostAddress();
                        String broadCHN = ifa.getBroadcast().getCanonicalHostName();
                        String broadHN = ifa.getBroadcast().getHostName();
                        System.out.println("     " + broadHA + " " + broadHN + " " + broadCHN);
                    }
                });

                System.out.println("MTU: " + ni.getMTU());

                System.out.print("InetAddresses:");
                for (Enumeration<InetAddress> iaddr = ni.getInetAddresses(); iaddr.hasMoreElements(); ) {
                    String name = iaddr.nextElement().getHostAddress();
                    System.out.print("   " + name);
                }
                System.out.println();

                byte[] ha = ni.getHardwareAddress();
                if (ha == null) {
                    System.out.println("HardwareAddress: null");
                } else {
                    String hardwareAddress = IntStream.range(0, ha.length)
                            .mapToObj(i -> Integer.toHexString(Byte.toUnsignedInt(ha[i])).toUpperCase())
                            .collect(Collectors.joining(":"));
//                    System.out.println(ha[1] + "  " + Integer.toString(Byte.toUnsignedInt(ha[1])));
                    System.out.println("HardwareAddress: " + hardwareAddress);
                }

                System.out.print("Parent: ");
                if (ni.getParent() != null) {
                    System.out.println(ni.getParent().getName());
                } else {
                    System.out.println("null");
                }
                System.out.println();

                System.out.println("SubInterfaces:");
                for (Enumeration<NetworkInterface> iface = ni.getSubInterfaces(); iface.hasMoreElements(); ) {
                    String name = iface.nextElement().getName();
                    System.out.print("   " + name);
                }
                System.out.println();
            }

        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }
}

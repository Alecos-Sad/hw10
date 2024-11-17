package org.example;


import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Решить задачу https://codeforces.com/contest/356/problem/A
     */
    @SneakyThrows
    public void championship(InputStream in, OutputStream out) {

        Scanner sc = new Scanner(in);
        PrintWriter writer = new PrintWriter(out);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] defeatedBy = new int[n + 1];

        TreeSet<Integer> activeKnights = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            activeKnights.add(i);
        }

        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int x = sc.nextInt();

            NavigableSet<Integer> inRange = activeKnights.subSet(l, true, r, true);

            List<Integer> toRemove = new ArrayList<>();
            for (int knight : inRange) {
                if (knight != x) {
                    defeatedBy[knight] = x;
                    toRemove.add(knight);
                }
            }

            toRemove.forEach(activeKnights::remove);
        }

        for (int i = 1; i <= n; i++) {
            writer.print(defeatedBy[i] + " ");
        }
        writer.flush();
    }
}
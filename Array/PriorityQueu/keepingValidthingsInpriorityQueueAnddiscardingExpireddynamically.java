import java.util.PriorityQueue;

class pair {
    int expiry;
    int amt;

    pair(int expiry, int amt) {
        this.expiry = expiry;
        this.amt = amt;
    }
}

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<pair> pq = new PriorityQueue<>((x, y) -> x.expiry - y.expiry);
        int n = days.length;
        int day = 0;
        int ans = 0;

        while (day < n || !pq.isEmpty()) {
            if (day < n && apples[day] > 0) {
                pq.offer(new pair(day + days[day], apples[day]));
            }

            while (!pq.isEmpty() && pq.peek().expiry <= day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pair p = pq.poll();
                p.amt--;
                ans++;
                if (p.amt > 0) {
                    pq.offer(p);
                }
            }

            day++;
        }

        return ans;
    }
}

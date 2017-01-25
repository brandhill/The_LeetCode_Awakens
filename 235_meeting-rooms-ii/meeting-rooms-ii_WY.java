/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length < 1) return 0;
        
        PriorityQueue<Interval> meetings = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if(a.start == b.start) return 0;
                return a.start < b.start ? -1 : 1;
            }
        });
        for(Interval meeting : intervals) {
            meetings.offer(meeting);
        }
        
        PriorityQueue<Interval> rooms = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if(a.end == b.end) return 0;
                return a.end < b.end ? -1 : 1;
            }
        });
        
        while(!meetings.isEmpty()) {
            Interval meeting = meetings.poll();
            Interval room = rooms.poll();
            if(room == null || room.end > meeting.start) {
                if(room != null) rooms.offer(room);
                rooms.offer(new Interval(meeting.start, meeting.end));
            } else {
                room.end = meeting.end;
                rooms.offer(room);
            }
        }
        
        return rooms.size();
    }
}

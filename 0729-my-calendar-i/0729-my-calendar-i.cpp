class MyCalendar {
public:
    vector<pair<int,int>>pq;
    MyCalendar() {
        
    }
    
    bool book(int start, int end) {
        for(auto &p: pq) {
            int st = p.first;
            int ed = p.second;
            if(start<ed && end > st) return false;
        }
        pq.push_back(make_pair(start,end));
        return true;
    }
};

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar* obj = new MyCalendar();
 * bool param_1 = obj->book(start,end);
 */
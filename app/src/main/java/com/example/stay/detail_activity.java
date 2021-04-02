package com.example.stay;

public class detail_activity {

        public   String name,addr,detail,price;

        public detail_activity() {
        }

        public detail_activity(String name, String addr, String price, String detail) {
            this.name = name;
            this.addr = addr;
            this.detail = detail;
            this.price = price;
        }

    public String getName() {
        return name;
    }

    public String getaddr() {
        return addr;
    }

    public String getDetail() {
        return detail;
    }

    public String getPrice() {
        return price;
    }
}

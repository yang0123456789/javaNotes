![image-20201214224857168](fastjson.assets/image-20201214224857168.png)
![image-20201214234247143](fastjson.assets/image-20201214234247143.png)

![image-20201214233613615](fastjson.assets/image-20201214233613615.png)

![image-20201214233628080](fastjson.assets/image-20201214233628080.png)



![image-20201214234223714](fastjson.assets/image-20201214234223714.png)



![image-20201214235053451](fastjson.assets/image-20201214235053451.png)

![image-20201214235115286](fastjson.assets/image-20201214235115286.png)

自定义全局bigdecima格式的配置

创建一个实现了object serializer的序列化器，实现write方法，

![image-20201215000046502](fastjson.assets/image-20201215000046502.png)



![image-20201215000422307](fastjson.assets/image-20201215000422307.png)

可以设置一个过滤器，这样每个对象都会走这个过滤器



![image-20201215000938179](fastjson.assets/image-20201215000938179.png)

![image-20201215001336062](fastjson.assets/image-20201215001336062.png)

第三种方式，使用valuerFilter

![image-20201215001707705](fastjson.assets/image-20201215001707705.png)
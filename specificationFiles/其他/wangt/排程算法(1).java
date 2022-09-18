排程算法 
	起始日期:0 //默认为0
	房间://房间编号	//户型		//工序名	//房间权重(唯一)
			101			A		A工序			1
			402			B		B工序			2
			103			A		A工序			3
			604			A		A工序			4
			206 		B		B个性化工序
	工序://工序名	//工序		//工种		//工程量	//工序次序
		A工序		测量放线 	木工活		2			2  
		A工序		砌筑隔墙 	油工		1			1
		A工序		隔断龙骨 	瓦工		0.2			6
		B工序		地暖保护层  木工		0.5			4  
	劳务公司:
			劳务队:	//队号		//人数                    
						1			4
						2			7
						3			10
			工种小组://小组号	//未完成(排程)	//完成天数		
						木工1		2 					1		
						木工2		2 					4
						木工3		2 					3
						油工1		2.5					0.5
						油工2		0 					4
						瓦工		2 					4
						验收													'4-8套一组空留两天'
			锁定任务://工人名	//房间编号	//未完成(排程)		//优先级	
						木工1		101				2				0
						木工1		402				3				0
						木工2		103				1				0
						瓦工 		604				1				0
	约束条件:'取开始日期=max(所有约束条件)'
			≥上一道工序结束时间+1
			≥材料送达时间等≥0
			
	
解决方式排产算法
单一房间工序最晚开始时间和最早开始时间
按照CR值排程（CR计算方法：交期减去目前日期之差额,再除以工期，数值越小表示紧急程度越高，排程优先级高）交付紧急排序
遍历楼房
	遍历工序
		遍历小组 加权 if
						
设备是有故障的，而故障又是偶发的，无从判断何时设备会出现故障。如果生产安排是时，进行倒排。
1、按照最短工期排程算法
2、按照交货期先后排程算法
3、按照工期和交货期之间的距离排程算法
4、按照CR值排程（CR计算方法：交期减去目前日期之差额再除以工期，数值越小表示紧急程度越高，排程优先级高）
5、最短工序排程算法

6、神经网络算法

7、模拟退火法

8、遗传算法

9、整单换线算法

10、拆单合单算法
	
	前期准备
			1.录入户型，录入对应的工序工程量（标准施工小组两人），工序次序，限制条件（日期）
			2.录入劳务队，录入对应劳务队成员及工种
			3.输入房间号<list>对应户型，输入劳务队
			工人  户型加权 房间加权 
			排序
 	一：
		·按照（栋，单元，楼层，户型）排序，这样能够尽可能地让工人的工作在同一栋楼里。
		·算法开始日期是从0计算
		 计算天数
	二：
	for(循环日期){
		
	}
		//遍历房间号<list>
		for(房间号：房间号list){
			//拿到单个房间的工序
			·拿到房间编号.户型.工序<list>
			·对工序按工序次序进行排序
			·创建队列	 以'0.5'天为块  工程量按工序次序分块入队 块包含工序名、是否需要同一人完成、最少人权值、
			
			
				
	}
	

	
	
	
	
	
	for(i=1;i<=MAX工序号;i++){
				if(i=1){
					设定	开始时间>=房间详细.材料送达时间
				}else{
					设定	开始时间>=房间详细.材料送达时间&&开始时间>=房间详细.n-1工序.结束时间+1
				 }
				开始时间=获取工序n-1.结束时间+1;
				结束时间=开始+工序详细;
				
				for(i=0;i<web.size;i++){
				
					
					
				}
	
1. 基于订单任务(Job-based)订单优先级计划

2. 基于事件(Event-based)资源利用率最大化计划

3. 基于资源(Resource-based，TOC)瓶颈约束计划

4. 基于物料约束的可行的计划

5. 基于历史，现在，未来的需求计划

6. 基于供应资源优化的分销配置计划

7. 基于运输资源优化运输计划


1.流程式模型，APS主要是顺序优化问题.

2.离散式模型，APS主要是解决多工序，多资源的优化调度问题.

3.流程和离散的混合模型，APS同时解决顺序和调度的优化问题.

4.项目管理模型，APS主要解决关键路径和成本时间最小化问题.


	erp系统 
	aps系统 
	
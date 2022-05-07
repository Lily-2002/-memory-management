package oprating;
import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
class pcb implements Runnable{
	private String pcbname;
	public pcb(String pcbname) {
		this.pcbname=pcbname;
	}
	public int  runtime;
	public int  room;
	
	public String getname() {
		return pcbname;
	}
	
	public void setname(String name) {
		pcbname=name;
	}
	public int gettime(int time) {
		return time;
	}
	private int Priority;
	public void setPriority(int power) {
		this.Priority=power;
	}
	public int getPriority() {
		return Priority;
	}
	
	public int status;
	public int iD;
	public void run() {
		
		System.out.println("PCB "+pcbname+" is running");
		
	}
	
	
	
}
class roomad{
	public int address;
	public int stu;
	public int length;
	public int getadd() {
		return address;
     }
	public int getstu() {
		return stu;
	}
	public int getlen() {
		return length;
	}
	public int L;
	public int getL() {
		return L;
	}
}

public class pcbprocess {
	public static void main(String[] args) {
		class MyComp implements Comparator<pcb>{
	        @Override
	        public int compare(pcb o1, pcb o2) {
	            return  (o1.getPriority() - o2.getPriority());
	        }
	        }
		PriorityQueue<pcb> queue=new PriorityQueue<>(new MyComp()) ;
		PriorityQueue<pcb> queue2=new PriorityQueue<>(new MyComp());//��
		Queue<pcb> queue3= new LinkedList<pcb>() ;//����
		Scanner sc = new Scanner(System.in);
	    int end=sc.nextInt();
	    int a[]=new int[90];
	    int A[]=new int[90];
	    System.out.println("pcb timepieces?");
		int timep=sc.nextInt();
		
		int num=0,j=0;
		
			System.out.println("δ�ַ�����");
			roomad partroom=new roomad();
			partroom.L=0;
			int arr=sc.nextInt();
			int Len=sc.nextInt();
			int b[]=new int[90];
			int B[]=new int[90];
			
			partroom.address=arr;
			partroom.length=Len;
			
			do {
			int choice = sc.nextInt();
		    switch (choice) {
		    case 1:
		    	System.out.println("�������");
		    	num++;
		    	
		    	System.out.println("�������������");
				String PCBname=sc.next();
				System.out.println("��������̵�����Ȩ");
				int power =sc.nextInt();
				System.out.println("�������������Ҫ��ʱ��");
				int runtime=sc.nextInt();
				System.out.println("�����������ռ�õĿռ�");
				int runroom=sc.nextInt();
				System.out.println("��������̵�״̬:1:�������;3:�����;5:�������");
				int S=sc.nextInt();
				
				
		        pcb pcb1=new pcb(PCBname);
				pcb1.runtime=runtime;
				pcb1.room=runroom;
				pcb1.status=S;
				pcb1.setPriority(power);
				if(pcb1.status==3)
					queue2.add(pcb1);
				if(pcb1.status==5)
					queue3.add(pcb1);
				int rest=partroom.length-partroom.L;
			    int f=0;
			   
			    if(pcb1.status==1) {
				for(int i=0;i<j;i++) {
						if(A[i]>runroom&&a[i]==0) {
							
								System.out.println("���䵽��"+(i+1)+"���ڴ�");
								f=1;
								queue.add(pcb1);
								a[i]=1;
							pcb1.iD=i;
						}
					}
				
				
			    if(f==0) {
					partroom.address=partroom.address+runroom;
					partroom.L=partroom.L+runroom;
					A[j]=pcb1.room;
					a[j]=1;
					pcb1.iD=j;
					j++;
					System.out.println("���䵽��"+j+"���ڴ�");
					queue.add(pcb1);
					
					f=1;
				}
			    if(f==0&&rest<pcb1.room)
					System.out.println("ʧ��,�ڴ治��");
				}
				
				pcb1.setPriority(power);
				
				if((queue2.isEmpty())==false) {
	    			int yy=0,done=0;
	    			pcb pcbh=queue2.poll();
		    	   for(int u=0;u<j;u++) {
		    		   if(A[u]>pcbh.room&&a[u]==0) {
		    		            pcbh.status=1;
								pcbh.iD=u;
								queue.add(pcbh);
								System.out.println("��"+(u+1)+"��"+"�Ѿ����󱸽���ռ��");
								yy=1;
								a[u]=1;
								done=1;
								break;
		    		   }
							
		    	   }
							if(yy==0) {
								 if((partroom.length-partroom.L)>pcbh.room) {
									 System.out.println("�ռ��㹻,�󱸳���ʼ����");
									 pcbh.status=1;
									 pcbh.iD=j;
									 queue.add(pcbh);
									 a[j]=1;
									 done=1;
									 System.out.println("�󱸳���ռ���˵�"+(j+1)+"���ڴ�");
									 j++;
									
								 }
							}
		    	   if(done==0) queue2.add(pcbh);
	    		}
			    break;
		    case 2:
		    	int time=timep;
		    	System.out.println("begin run");
		    		
		    		
		    		while(time>0) {
		    			if((queue.isEmpty())==true) {
		    				break;
		    			}
			    		 pcb pcbt=queue.poll();
			             Thread ft2 = new Thread(pcbt);
						 ft2.start();
					while(pcbt.runtime>0&&time>0) {
					time--;
					pcbt.runtime--;
					int power2=pcbt.getPriority();
				    pcbt.setPriority(power2+1);
					}
					
				
				if(pcbt.runtime==0) {
					a[pcbt.iD]=0;
					partroom.L=partroom.L-pcbt.room;
					System.out.println("���ս���"+pcbt.getname()+"��");
					System.out.println("�ͷŵ�"+(pcbt.iD+1)+"���ڴ�");
					
						
					
				}
				if(pcbt.runtime>0&&time==0) {
					queue.add(pcbt);
					}
		       
					
		    		   
		    }
		    	break;
			
			
		    		
		    case 3:
		    	System.out.println("��ҹ���");
		    	System.out.println("��ҵĽ�������");
		    	String pcbr=sc.next();
		    	int xx=0;
		    	int find=0;
		    	for(int i=0;i<j;i++) {
		    		if((queue3.isEmpty())==false) {
		    		pcb pcbj=queue3.poll();
		    		if(pcbr.equals(pcbj.getname())) {
		    			find=1;
		    			System.out.println("��Ҹý���");
		    			
		    			for(int r=0;r<j;r++) {
		    				if(pcbj.room<=A[r]&&a[r]==0) {
		    					pcbj.status=1;
		    					pcbj.iD=r;
		    					queue.add(pcbj);
		    					System.out.println("��"+(r+1)+"��"+"�Ѿ�����ҽ���ռ��");
		    					xx=1;
		    					a[r]=1;
		    					break;
		    				}
		    				if(xx==0) {
								 if((partroom.length-partroom.L)>=pcbj.room) {
									 System.out.println("�ռ��㹻,��ҳ���ʼ����");
									 pcbj.status=1;
									 pcbj.iD=j;
									 queue.add(pcbj);
									 System.out.println("���䵽�˵�"+(j+1)+"���ڴ�");
									 a[j]=1;
									 j++;
									 break;}
								if((partroom.length-partroom.L)<pcbj.room) {
									queue3.add(pcbj);
								 }
		    				}
		    		}
		    		}
		    		
		    			
		    	}
		    	
		    }
		    	if(find==0) {
		    		System.out.println("�Ҳ���");
		    	}
		    	break;
		    case 4:
		    	System.out.println("����");
		    	int flag,t=0;
		    	for(int i=0;i<j;i++) {
					flag=0;
					
					while(a[i]==0) {
						b[t]=A[i]+b[t];
						B[t]=0;
						i++;
						
						if(i>=j) break;
						flag=1;
					}
					
					
					if(flag==1)
					t++;
					
					if(a[i]==1) {
						b[t]=A[i];
						B[t]=1;
						t++;
					}
					
				}
		    	for(int i=0;i<t;i++) {
		    		A[i]=b[i];
		    		a[i]=B[i];
		    	}
		    	System.out.println("���ڵ��ڴ�������");
		    	if(t==1&&a[0]==0) {
		    		System.out.println("��"+1+"��:"+partroom.length);
		    	}
		    	for(int i=0;i<t;i++) {
		    		
		    		System.out.println("��"+(i+1)+"��:"+A[i]);
		    	}
		    	j=t;
		    }
		    }while(end!=0000);
}
			}

			
	



			

	
			
			
			
			
			
			
		
			
			

	    
		
	
		



package swingtest;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import swingtest.pcb;
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
		
		
		System.out.print( pcbname+" is running\n");
		
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
class B{
	String p=JOptionPane.showInputDialog("��������Ҫ�Ĳ�����1.�������� 2.���н��� 3.δ�ַ��������� 4.��� 5.�鿴����״�� 6.�ϲ����ڿ����� 7.�˳�");
public int buid() {
	int P = Integer.parseInt(p);
 return P;
}}
 class swing2
{
	
static	JFrame fr;
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
    int a[]=new int[90];
    int A[]=new int[90];
	int timep=2;
	
	int num=0,j=0;
	
		roomad partroom=new roomad();
		partroom.L=0;
		int b[]=new int[90];
		int B[]=new int[90];
		
		
while(true) {
	B first=new B();
	if(first.buid()==7) {
		break;
	}
	if(first.buid()==3)
	{
			
			String Arr=JOptionPane.showInputDialog("�������׵�ַ");
			int arr = Integer.parseInt(Arr);
			String len=JOptionPane.showInputDialog("��������");
			int Len =Integer.parseInt(len);
			
			partroom.address=arr;
			partroom.length=Len;
	}


if(first.buid()==1)
{
	num++;
	String PCBname=JOptionPane.showInputDialog("�������������");
	String pow=JOptionPane.showInputDialog("��������̵�����Ȩ");
	int power = Integer.parseInt(pow);
	String RR=JOptionPane.showInputDialog("�������������Ҫ��ʱ��");
	int runtime=Integer.parseInt(RR);
	String AA=JOptionPane.showInputDialog("�������������Ҫ�Ŀռ�");
	int runroom=Integer.parseInt(AA);
	String WE=JOptionPane.showInputDialog("��������̵�״̬:1:�������;3:�����;5:�������");
	int S=Integer.parseInt(WE);
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
				
				JOptionPane.showInputDialog(fr,"���䵽��"+(i+1)+"���ڴ�");
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
		JOptionPane.showMessageDialog(fr, "���䵽��"+j+"���ڴ�");
		queue.add(pcb1);
		
		f=1;
	}
    if(f==0&&rest<pcb1.room)
    	JOptionPane.showMessageDialog(fr, "ʧ��,�ڴ治��");
	}
	
	pcb1.setPriority(power);
	
}
if(first.buid()==2) {
	int yy=0,done=0;
	if(queue2.isEmpty()==false) {
		pcb pcbt=queue2.poll();
	   for(int u=0;u<j;u++) {
		   if(A[u]>pcbt.room&&a[u]==0) {
		            pcbt.status=1;
					pcbt.iD=u;
					queue.add(pcbt);
					JOptionPane.showMessageDialog(fr,"��"+(u+1)+"��"+"�Ѿ����󱸽���ռ��");
					yy=1;
					a[u]=1;
					done=1;
					break;
		   }
				
	   }
				if(yy==0) {
					 if((partroom.length-partroom.L)>pcbt.room) {
						 JOptionPane.showMessageDialog(fr,"�ռ��㹻,�󱸳���ʼ����");
						 pcbt.status=1;
						 pcbt.iD=j;
						 queue.add(pcbt);
						 a[j]=1;
						 A[j]=pcbt.room;
						 done=1;
						 JOptionPane.showMessageDialog(fr,"�󱸳���ռ���˵�"+(j+1)+"���ڴ�");
						 j++;
						
					 }
				}
	   if(done==0) queue2.add(pcbt);}
	int time=timep;
	
	
		while(time>0) {
			if(queue.isEmpty()==true) {
				JOptionPane.showMessageDialog(fr, "����Ϊ��");
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
		JOptionPane.showMessageDialog(fr, "���ս���"+pcbt.getname()+"��,�ͷŵ�"+(pcbt.iD+1)+"���ڴ�");
	}
	if(pcbt.runtime>0&&time==0) {
		queue.add(pcbt);
		}
			
			
		
		   
}
}

if(first.buid()==4) {
	String pcbr=JOptionPane.showInputDialog("�������ҽ�������");
	int xx=0;
	int find=0;
	int DONE=0;
	for(int i=0;i<num;i++) {
		if((queue3.isEmpty())==false) {
		pcb pcbj=queue3.poll();
		if(pcbr.equals(pcbj.getname())) {
			find=1;
			JOptionPane.showMessageDialog(fr,"�ҵ��ý���");
			
			for(int r=0;r<j;r++) {
				if(pcbj.room<=A[r]&&a[r]==0) {
					pcbj.status=1;
					pcbj.iD=r;
					queue.add(pcbj);
					JOptionPane.showMessageDialog(fr,"��"+(r+1)+"��"+"�Ѿ�����ҽ���ռ��");
					xx=1;
					a[r]=1;
					DONE=1;
					break;
				}
			}
				if(xx==0) {
					 if((partroom.length-partroom.L)>=pcbj.room) {
						 JOptionPane.showMessageDialog(fr,"�ռ��㹻,��ҳ���ʼ����");
						 pcbj.status=1;
						 pcbj.iD=j;
						 queue.add(pcbj);
						 JOptionPane.showMessageDialog(fr,"���䵽�˵�"+(j+1)+"���ڴ�");
						 a[j]=1;
						 A[j]=pcbj.room;
						 j++;
						 DONE=1;
						 }
					
				}
				if(DONE==0) {
					queue3.add(pcbj);
					JOptionPane.showMessageDialog(fr,"�ڴ治��");
				 }
		}
		if(pcbr.equals(pcbj.getname())==false)
			queue3.add(pcbj);
		
	}
		
	
}
	if(find==0) {
		
		JOptionPane.showMessageDialog(fr,"�Ҳ���");
	}
	
}

if(first.buid()==5) {
	
	if((queue.isEmpty())==true) {
		JOptionPane.showMessageDialog(fr,"��������Ϊ��");
	}
	if((queue.isEmpty())==false) {
	pcb pcbs=queue.poll();
	Integer sr=pcbs.room;
	String str=sr.toString();
	Integer st=pcbs.runtime;
	String sT=st.toString();
	Integer ss=pcbs.status;
	String SS=ss.toString();
	JOptionPane.showMessageDialog(fr,"�������������������"+pcbs.getname()+"ռ�ÿռ�Ϊ��"+str+"����ʱ��Ϊ��"+sT+"����Ȩ"+SS);
    queue.add(pcbs);
	}
	
	if((queue2.isEmpty())==true) {
		JOptionPane.showMessageDialog(fr,"�󱸶���Ϊ��");
	}
	else {
	
	pcb pcbs1=queue2.poll();
	Integer sr1=pcbs1.room;
	String str1=sr1.toString();
	Integer st1=pcbs1.runtime;
	String sT1=st1.toString();
	Integer ss1=pcbs1.status;
	String SS1=ss1.toString();
	JOptionPane.showMessageDialog(fr,"�󱸶��������������"+pcbs1.getname()+"ռ�ÿռ�Ϊ��"+str1+"����ʱ��Ϊ��"+sT1+"����Ȩ"+SS1);
	queue2.add(pcbs1);
	 }
	if((queue3.isEmpty())==true) {
		JOptionPane.showMessageDialog(fr,"�������Ϊ��");
	}
	else {
	
	pcb pcbs2=queue3.poll();
	Integer sr2=pcbs2.room;
	String str2=sr2.toString();
	Integer st2=pcbs2.runtime;
	String sT2=st2.toString();
	Integer ss2=pcbs2.status;
	String SS2=ss2.toString();
	JOptionPane.showMessageDialog(fr,"������������������"+pcbs2.getname()+"ռ�ÿռ�Ϊ��"+str2+"����ʱ��Ϊ��"+sT2+"����Ȩ"+SS2);
	queue3.add(pcbs2);
	}
	
    
   
    
    
    
    
}
int flag,t=0;
if(first.buid()==6) {

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

j=t;
JOptionPane.showMessageDialog(fr,"�ϲ����");
}

}
}}

	






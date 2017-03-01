package pic;
import java.util.*;
import java.io.*;
public class str 
{
	public String file1,file2;
	public String a,b,ans,ans2;
	
	  int cal_fre(String a,String b)
        {
            int fre=0;
            StringTokenizer st=new StringTokenizer(a," ");
            while(st.hasMoreElements())
            {
                if(b.equals(st.nextToken()))
                fre++;
            }
        return fre;
        }
        void create_hash(LinkedHashMap ht,LinkedHashMap ht1,StringTokenizer st, String a)
        {
            String s;
                while(st.hasMoreTokens())
        {
            s=st.nextToken();
            int fre=cal_fre(a,s);
         //   
           if(ht.containsKey(s))
           {
               int t=(int)ht.get(s);
               if(t!=0)
               {}
               else
               {
               ht.put(s,fre);
            }
            } 
           else
            {
                ht.put(s,fre);
               ht1.put(s,0);
            }
            
        }
        }
        float check_per(LinkedHashMap<String,Integer> ht,LinkedHashMap<String,Integer> ht1,float l1,float l2)
        {
            float t=0;
             for (String key :ht.keySet())
            {
             int value = (int)ht.get(key);
             int value1=(int)ht1.get(key);
             t+=value*value1;
            }
            t=t/(l1*l2);
            return t;
        }
	//new code
    public void open(String file1,String file2)throws IOException
    {
        LinkedHashMap<String,Integer> ht=new LinkedHashMap<String,Integer>();
        LinkedHashMap<String,Integer> ht1=new LinkedHashMap<String,Integer>();
        String s;
        InputStreamReader ir=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(ir);
		this.file1=file1;
		this.file2=file2;
        System.out.println("Enter the first file name");
        //String file1=br.readLine();
           // System.out.println("Enter the 2nd file name");
        //String file2=br.readLine();
        FileInputStream fin1=null;
        FileInputStream fin2=null;
        try
        {
            fin1=new FileInputStream(file1);
            fin2=new FileInputStream(file2);
        }
        catch(FileNotFoundException fe)
        {
            System.out.println("file not found");
            return ;
        }
        BufferedInputStream bin1=new BufferedInputStream(fin1);
        BufferedInputStream bin2=new BufferedInputStream(fin2);
        //String a="";
        //String b="";
        int ch;
      //  bin.readLine();
      //  bin.readLine();
        while((ch=bin1.read())!=-1)
        {
            a=a+(char)ch;
        }
        while((ch=bin2.read())!=-1)
        {
            b=b+(char)ch;
        }
       /* String a="this this is a dog so i want a dog";
        String b="this is a cat";*/
      //  String a="this is a dog";
       // String b="thi it aa cat";
         // System.out.println(a);
       // System.out.println(b);
        bin1.close();
        bin2.close();
        StringTokenizer st=new StringTokenizer(a," ");
        StringTokenizer st1=new StringTokenizer(b," ");
        
        //str obj=new str();
        create_hash(ht,ht1,st,a);
        create_hash(ht1,ht,st1,b);
for (String key : ht.keySet())
 {
    Integer value = ht.get(key);
    System.out.println("Key = " + key + ", Value = " + value);
}
System.out.println();
for (String key : ht1.keySet())
 {
    Integer value = ht1.get(key);
    System.out.println("Key = " + key + ", Value = " + value);
}
System.out.println();
System.out.println();
float l1=0;
float l2=0;
//
//
for (String key : ht.keySet())
 {
    float value = (float)ht.get(key);
    l1+=value*value;
}
l1=(float)Math.sqrt(l1);
System.out.println(l1);
//
//
//    
for (String key : ht.keySet())
 {
    float value = (float)ht1.get(key);
    l2+=value*value;
}
l2=(float)Math.sqrt(l2);
System.out.println(l2);  
//
//
//
float p=check_per(ht,ht1,l1,l2);
int angle=(int)Math.toDegrees((Math.acos(p)));
ans="Documents are at "+angle+" angle to each other";
ans2="Documents are  "+p*100+"% similar";

}
    }//end of class
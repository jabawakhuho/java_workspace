class Plant{
   String name="�� �Ĺ�";

   public void grow(){
      System.out.println("�Ĺ��� �ڶ��ϴ�.");
   }
}

class Flower extends Plant{
   String name="�� ��";

   public void grow(){
      System.out.println("���� �ڶ��ϴ�.");
   }

}

class UsePlant{
   public static void main(String[] args){
        Plant p1=new Plant();           (A)
        System.out.println(p1.name);  (B)
        
        Plant p2=new Flower(); (C)         
        System.out.println(p2.name);  (D)
     
        p2.grow(); (F)
   }
}

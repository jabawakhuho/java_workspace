class Plant{
   String name="난 식물";

   public void grow(){
      System.out.println("식물이 자랍니다.");
   }
}

class Flower extends Plant{
   String name="난 꽃";

   public void grow(){
      System.out.println("꽃이 자랍니다.");
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

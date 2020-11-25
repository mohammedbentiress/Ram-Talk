package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IRequestHandler {
    @GET("Admin/API/Login/login.php")
    Call<User> login(@Query("username") String par1, @Query("password") String par2);

    @GET("Admin/API/Deconnection/deco.php")
    Call<String> deco(@Query("id") int id);

    @GET("Admin/API/Changeusername/updateusername.php")
    Call<User> updateusername(@Query("old_username")String old_username,@Query("new_username")String new_username,@Query("password")String password,@Query("id") int id);

    @GET("Admin/API/Changepassword/updatepassword.php")
    Call<User> updatepassword(@Query("username")String username,@Query("old_password")String old_password,@Query("new_password")String new_password,@Query("id") int id);

    @GET("Admin/API/Affichagecontact/affichagecontact.php")
    Call<List<Contact>> affichagecontact(@Query("id") int id);

    @GET("Admin/API/Affichageservice/affichageservice.php")
    Call<List<Service>> affichageservice();

    @GET("Admin/API/getcurrentusername.php")
    Call<String> getusername(@Query("id") int id);

    @GET("Admin/API/Conversation/conversation.php")
    Call<List<Conversation>> getConversation(@Query("id") int id);

    @GET("Admin/API/Messages/affichagedesmessages.php")
    Call<List<Messages>> affichagemessages(@Query("id_emetteur") int id_emetteur,@Query("id_recepteur") int id_recepteur);

    @GET("Admin/API/Messages/envoiedesmessages.php")
    Call<Boolean> Envoyer(@Query("id_emetteur") int id_emetteur,@Query("id_recepteur") int id_recepteur,@Query("Text") String str);
}

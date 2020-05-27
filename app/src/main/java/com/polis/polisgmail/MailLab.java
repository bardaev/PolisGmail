package com.polis.polisgmail;

import android.content.Context;

import androidx.room.Room;

import com.polis.polisgmail.dao.Mail;
import com.polis.polisgmail.models.sql.DataBase;
import com.polis.polisgmail.models.sql.DataBaseMailDao;

import java.util.List;

public class MailLab {

    private static MailLab mailLab;

    private List<Mail> mailList;

    private DataBase db;
    private DataBaseMailDao dao;

    public static MailLab get(Context context) {
        if (mailLab == null) {
            mailLab = new MailLab(context);
        }

        return mailLab;
    }

    private MailLab(Context context) {
        //use only first time
        String[] arr = {"andrew59@yahoo.com" ,
                "reynoldskendra@rose-singh.com" ,
                "jamielevine@ewing.biz" ,
                "smiller@yahoo.com" ,
                "valerie66@walker.biz" ,
                "andrewgomez@weaver-diaz.com" ,
                "billyacevedo@gmail.com" ,
                "pinedasamantha@hotmail.com" ,
                "qlopez@hotmail.com" ,
                "kelsey46@gmail.com" ,
                "cummingschristopher@hotmail.com" ,
                "hmcconnell@lucas.com" ,
                "zfischer@yahoo.com" ,
                "ballardmichael@garza.net" ,
                "xwhitehead@mitchell.com" ,
                "cameroncrystal@oconnor.com" ,
                "pamela42@gmail.com" ,
                "allison07@gmail.com" ,
                "maryross@yahoo.com" ,
                "david07@small.com"};
        db = Room.databaseBuilder(context.getApplicationContext(),
                DataBase.class, "DataBase").allowMainThreadQueries().build();
        dao = db.mailDao();
        for (int i = 0; i < -1; i++) {
            Mail mail = new Mail();
            mail.setFrom("Sender: Sender # " + arr[i]);
            mail.setTo("To:" + arr[19 - i]);
            mail.setTheme("Theme: Theme #" + i);
            mail.setMessage("Message: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus ac enim ac leo auctor tincidunt id ut arcu. Nullam fermentum, ante nec scelerisque ullamcorper, dui tellus condimentum enim, sit amet malesuada magna metus quis nisl. Donec viverra dui sit amet erat sollicitudin aliquet. Morbi enim purus, iaculis convallis lacinia id, vestibulum vitae ipsum. Quisque commodo tortor lorem, in vulputate enim mollis viverra. Sed accumsan, mi a luctus scelerisque, lacus lectus tempor arcu, vel tempor lorem lectus eget tortor. Proin suscipit, dui quis molestie posuere, dolor libero posuere ligula, nec consequat erat nulla non magna. Donec in ultrices nibh. Quisque euismod diam nec quam dignissim, a faucibus justo scelerisque. Duis condimentum vulputate nisl." +
                    "\n" +
                    "Cras eget tempor tellus. Quisque tincidunt urna in purus suscipit ullamcorper. Praesent id nibh eget ante mattis scelerisque. Ut sagittis vulputate eros. Sed in ultrices ante. Mauris eleifend mollis diam, a venenatis felis pellentesque porttitor. Pellentesque ipsum augue, porta quis augue in, gravida volutpat nunc. Proin placerat sem sem, nec consequat velit mattis nec. Cras sapien quam, dictum vel magna sed, bibendum bibendum purus. Ut leo ipsum, varius eu facilisis ut, vestibulum convallis ligula. Phasellus tempor, nunc quis viverra aliquam, libero dolor commodo purus, eget malesuada magna ligula a orci.");
            dao.insert(mail);
        }
    }

    public List<Mail> getMails() {
        return mailList = dao.getAll();
    }

    public Mail getMail(Long uuid) {
        for (Mail mail : mailList) {
            if (mail.getUuid().equals(uuid)) {
                return mail;
            }
        }

        return null;
    }
}

package com.polis.polisgmail;

import android.content.Context;

import com.polis.polisgmail.dao.Mail;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MailLab {

    private static MailLab mailLab;

    private List<Mail> mailList;

    public static MailLab get(Context context) {
        if (mailLab == null) {
            mailLab = new MailLab(context);
        }

        return mailLab;
    }

    private MailLab(Context context) {
        mailList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Mail mail = new Mail();
            mail.setFrom("Sender: Sender # " + i);
            mail.setTo("To:" + i);
            mail.setTheme("Theme: Theme #" + i);
            mail.setMessage("Message: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus ac enim ac leo auctor tincidunt id ut arcu. Nullam fermentum, ante nec scelerisque ullamcorper, dui tellus condimentum enim, sit amet malesuada magna metus quis nisl. Donec viverra dui sit amet erat sollicitudin aliquet. Morbi enim purus, iaculis convallis lacinia id, vestibulum vitae ipsum. Quisque commodo tortor lorem, in vulputate enim mollis viverra. Sed accumsan, mi a luctus scelerisque, lacus lectus tempor arcu, vel tempor lorem lectus eget tortor. Proin suscipit, dui quis molestie posuere, dolor libero posuere ligula, nec consequat erat nulla non magna. Donec in ultrices nibh. Quisque euismod diam nec quam dignissim, a faucibus justo scelerisque. Duis condimentum vulputate nisl.\n" +
                    "\n" +
                    "Cras eget tempor tellus. Quisque tincidunt urna in purus suscipit ullamcorper. Praesent id nibh eget ante mattis scelerisque. Ut sagittis vulputate eros. Sed in ultrices ante. Mauris eleifend mollis diam, a venenatis felis pellentesque porttitor. Pellentesque ipsum augue, porta quis augue in, gravida volutpat nunc. Proin placerat sem sem, nec consequat velit mattis nec. Cras sapien quam, dictum vel magna sed, bibendum bibendum purus. Ut leo ipsum, varius eu facilisis ut, vestibulum convallis ligula. Phasellus tempor, nunc quis viverra aliquam, libero dolor commodo purus, eget malesuada magna ligula a orci.");
            mailList.add(mail);
        }
    }

    public List<Mail> getMails() {
        return mailList;
    }

    public Mail getMail(UUID uuid) {
        for (Mail mail : mailList) {
            if (mail.getUuid().equals(uuid)) {
                return mail;
            }
        }

        return null;
    }
}

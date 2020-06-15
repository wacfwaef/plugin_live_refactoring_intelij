package highlight;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.project.Project;
import com.intellij.ui.AnimatedIcon;

import javax.swing.*;

public class GroupNoti {

        //creation of notification group for type notification
        public static final NotificationGroup noti_group =
                new NotificationGroup("resultnoti",
                        NotificationDisplayType.TOOL_WINDOW,
                        true);

        public static final NotificationGroup no_group =
                new NotificationGroup("resultno",
                        NotificationDisplayType.BALLOON,
                        true);


        //notification 1st smell - try line test
        public static void createNotificationa(int line, Project project){
                Icon icon = new AnimatedIcon.Default();
                Notification msg = new Notification(noti_group.getDisplayId(),icon,
                        "Code smell found:","Method findViewById" ,
                        "You are using the class findViewById on line " + line + " and it's energy inefficient." +
                                "Refactoring: replace with ViewHolder pattern.", NotificationType.WARNING,null);
                msg.notify(project);
        }

        //notification 2nd smell
        public static void createNotificationb(int line, Project project){
                Icon icon = new AnimatedIcon.Default();
                Notification msg = new Notification(noti_group.getDisplayId(),icon,
                        "Code smell found:","Wakelock usage" ,
                        "You are using wakelock on line " + line + " without using method onPause() and it's energy inefficient." +
                                "Refactoring: add the method onPause().", NotificationType.WARNING,null);
                msg.notify(project);
        }

        //notification 3rd smell
        public static void createNotificationc(int line, Project project){
                Icon icon = new AnimatedIcon.Default();
                Notification msg = new Notification(noti_group.getDisplayId(),icon,
                        "Code smell found:","Private get/set methods" ,
                        "You are using get/set methods on line " + line + " and it's energy inefficient." +
                                "Refactoring: replace with inline methods.", NotificationType.WARNING,null);
                msg.notify(project);
        }

        //notification 4th smell
        public static void createNotificationd(int line, Project project){
                Icon icon = new AnimatedIcon.Default();
                Notification msg = new Notification(noti_group.getDisplayId(),icon,
                        "Code smell found:","Hashmap usage" ,
                        "You are using Hashmap on line " + line + " and it's energy inefficient." +
                                "Refactoring: replace with ArrayMap.", NotificationType.WARNING,null);
                msg.notify(project);
        }

        public static void createNotificationNo(Project project){
                Notification msg = new Notification(no_group.getDisplayId(),"Scan finished","Scan is finished",NotificationType.INFORMATION);
                msg.notify(project);
        }
}

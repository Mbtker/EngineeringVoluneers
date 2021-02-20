package mbtkerteam.com.engvolunteered;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;

import org.json.JSONArray;

import java.util.ArrayList;

import mbtkerteam.com.engvolunteered.Helpers.ChallengesModel;
import mbtkerteam.com.engvolunteered.Helpers.EventsModel;
import mbtkerteam.com.engvolunteered.Helpers.GlobalVariable;
import mbtkerteam.com.engvolunteered.Helpers.GroupsModel;
import mbtkerteam.com.engvolunteered.Helpers.InterestingModel;
import mbtkerteam.com.engvolunteered.Helpers.VolunteerModel;

public class IntroActivity extends AppCompatActivity {

    public static ArrayList<InterestingModel> InterestingList = new ArrayList<>();
    public static ArrayList<VolunteerModel> VolunteerList = new ArrayList<>();
    public static JSONArray CityArray = new JSONArray();
    public static JSONArray FilesArray = new JSONArray();
    public static ArrayList<GroupsModel> GroupsList = new ArrayList<>();
    public static ArrayList<ChallengesModel> ChallengesList = new ArrayList<>();
    public static ArrayList<EventsModel> EventsList = new ArrayList<>();
    boolean iSLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        SharedPreferences sharedPreferences = getSharedPreferences("LoginStatus", Context.MODE_PRIVATE);
        iSLogin = sharedPreferences.getBoolean("iSLogin", false);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        GlobalVariable.Width = dm.widthPixels;
        GlobalVariable.Hight = getResources().getDisplayMetrics().density;

        iniCites();

        iniInteresting();

        initLoading();
    }
    private void iniCites()
    {
        CityArray.put("الكـل");
        CityArray.put("الرياض");
        CityArray.put("المدينة المنورة");
        CityArray.put("مكة المكرمة");
        CityArray.put("الدمام");
        CityArray.put("القصيم");
        CityArray.put("جازان");

    }

    private void iniInteresting()
    {
        InterestingList.add(new InterestingModel("1","تطوع عام",false));
        InterestingList.add(new InterestingModel("2","هندسي",false));
        InterestingList.add(new InterestingModel("3","تقني",false));
        InterestingList.add(new InterestingModel("4","مهاري",false));
        InterestingList.add(new InterestingModel("5","إدارة فريق",false));
        InterestingList.add(new InterestingModel("6","ناشر محتوى",false));
        InterestingList.add(new InterestingModel("7","موثق محتوى",false));
        InterestingList.add(new InterestingModel("8","باحث",false));

        FilesArray.put("الكـل");
        FilesArray.put("تطوع عام");
        FilesArray.put("هندسي");
        FilesArray.put("تقني");
        FilesArray.put("مهاري");
        FilesArray.put("إدارة فريق");
        FilesArray.put("ناشر محتوى");
        FilesArray.put("موثق محتوى");
        FilesArray.put("باحث");

        VolunteerList.add(new VolunteerModel("1", R.drawable.groups_icon, "جمعية البر الخيرية بجزان", "الاشراف على وقف (تحت الانشاء) للجمعية", "1 مارس - 31 مارس", "جازان", "5", "هندسي", "1", false, "القيام بزيارات اشرافية للمبنى , رفع تقرير عن الملاحظات التي يراها ", false, false));
        VolunteerList.add(new VolunteerModel("2", R.drawable.groups_icon, "تصميم مدخل لذوي الاحتياجات الخاصة", "تصميم مدخل و واجهة مبنى بحيث تتناسب مع ذوي الاحتياجات الخاصة", "15 فبراير - 25 فبراير", "الاحساء", "3", "هندسي", "3", true, "تصميم مدخل و واجهة مبنى بحيث تتناسب مع ذوي الاحتياجات الخاصة المقصود سهولة الدخول و الخروج لأصحاب ذوي الاحتياجات الخاصة تنساق الشكل الكلي للمبنى", false, false));
        VolunteerList.add(new VolunteerModel("3", R.drawable.groups_icon, "مستشار معماري", "تقديم استشارات معمارية وهندسية للأفراد الذين يخططون للبناء", "1 مارس - 31 مارس", "الرياض", "4", "هندسي", "3",true, "تقديم 3 استشارات يومية معمارية وهندسية للأفراد الذين يخططون للبناء", false, false));
        VolunteerList.add(new VolunteerModel("4", R.drawable.groups_icon, "مستشار زراعي", "يقوم المتطوع بالوقوف على اعمال التشجير الخاصة بالجمعية السابقة و القادمة و تقديم الرأي الفني لضمان نجاح العمل", "7 فبراير - 6 مارس", "المدينة المنورة", "2", "هندسي", "ذكور", false, "يقوم المتطوع بالوقوف على اعمال التشجير الخاصة بالجمعية السابقة و القادمة و تقديم الرأي الفني لضمان نجاح العمل", false, false));
        VolunteerList.add(new VolunteerModel("5", R.drawable.groups_icon, "مصمم/ة ديكور لقاعات الجمعية", "مصمم/ة ديكور لإعادة تصميم قاعات الجمعية بشكل وبإضافات جديدة مميزة", "7 فبراير - 28 فبراير", "مكة المكرمة", "2", "هندسي", "3", true, "مصمم/ة ديكور لإعادة تصميم قاعات الجمعية بشكل وبإضافات جديدة مميزة", false, false));

        VolunteerList.add(new VolunteerModel("1", R.drawable.groups_icon, "جمعية البر الخيرية بجزان 2", "الاشراف على وقف (تحت الانشاء) للجمعية", "1 مارس - 31 مارس", "جازان", "5", "هندسي", "1", false, "القيام بزيارات اشرافية للمبنى , رفع تقرير عن الملاحظات التي يراها ", false, false));
        VolunteerList.add(new VolunteerModel("2", R.drawable.groups_icon, "تصميم مدخل لذوي الاحتياجات الخاصة 2", "تصميم مدخل و واجهة مبنى بحيث تتناسب مع ذوي الاحتياجات الخاصة", "15 فبراير - 25 فبراير", "الاحساء", "3", "هندسي", "3", true, "تصميم مدخل و واجهة مبنى بحيث تتناسب مع ذوي الاحتياجات الخاصة المقصود سهولة الدخول و الخروج لأصحاب ذوي الاحتياجات الخاصة تنساق الشكل الكلي للمبنى", false, false));
        VolunteerList.add(new VolunteerModel("3", R.drawable.groups_icon, "مستشار معماري 2", "تقديم استشارات معمارية وهندسية للأفراد الذين يخططون للبناء", "1 مارس - 31 مارس", "الرياض", "4", "هندسي", "3",true, "تقديم 3 استشارات يومية معمارية وهندسية للأفراد الذين يخططون للبناء", false, false));
        VolunteerList.add(new VolunteerModel("4", R.drawable.groups_icon, "مستشار زراعي 2", "يقوم المتطوع بالوقوف على اعمال التشجير الخاصة بالجمعية السابقة و القادمة و تقديم الرأي الفني لضمان نجاح العمل", "7 فبراير - 6 مارس", "المدينة المنورة", "2", "هندسي", "ذكور", false, "يقوم المتطوع بالوقوف على اعمال التشجير الخاصة بالجمعية السابقة و القادمة و تقديم الرأي الفني لضمان نجاح العمل", false, false));
        VolunteerList.add(new VolunteerModel("5", R.drawable.groups_icon, "مصمم/ة ديكور لقاعات الجمعية 2", "مصمم/ة ديكور لإعادة تصميم قاعات الجمعية بشكل وبإضافات جديدة مميزة", "7 فبراير - 28 فبراير", "مكة المكرمة", "2", "هندسي", "3", true, "مصمم/ة ديكور لإعادة تصميم قاعات الجمعية بشكل وبإضافات جديدة مميزة", false, false));

        GroupsList.add(new GroupsModel("1","فرقة المهام الطارئة",""));
        GroupsList.add(new GroupsModel("2","فرقة التطوع العام",""));
        GroupsList.add(new GroupsModel("3","فرقة البحث والتطوير",""));
        GroupsList.add(new GroupsModel("4","فرقة الاشراف الهندسي",""));
        GroupsList.add(new GroupsModel("5","فرقة توثيق المحتوى",""));
        GroupsList.add(new GroupsModel("6","فرقة اعمال الكهرباء",""));
        GroupsList.add(new GroupsModel("7","فرقة منطقة الشرقية",""));
        GroupsList.add(new GroupsModel("7","فرقة منطقة الجوف",""));

        ChallengesList.add(new ChallengesModel("1","جدوى تطبيق أنظمة الطاقة الشمسية في المناطق النائية","", "25"));
        ChallengesList.add(new ChallengesModel("2","ترشيد استهلاك الماء والكهرباء","", "14"));
        ChallengesList.add(new ChallengesModel("3","تلقي المعلومات والارشادات الهندسية من مصادر موثوقة","", "10"));

        EventsList.add(new EventsModel("" ,"اليوم العالمي للتطوع", "5 ديسمبر", "فندق الريتز كاليرتون"));
        EventsList.add(new EventsModel("" ,"اللقاء الدوري لأعضاء جمعية التطوع الهندسي", "6 جون", "لقاء افتراضي"));
        EventsList.add(new EventsModel("" ,"الجمعية العمومية الأولى", "31 ديسمبر", "لم يحدد بعد"));
        EventsList.add(new EventsModel("" ,"لقاء بعنوان فوائد التطوع للمتطوعين وللمجتمع", "5 مايو", "لقاء افتراضي"));
    }

    private void initLoading()
    {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1s = 1000ms

                if (iSLogin)
                {
                    Intent intent = new Intent(getApplicationContext(), EngMainActivity.class);
                    startActivity(intent);

                } else
                {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }

            }

        }, 1000);


    }
}
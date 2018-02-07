package com.example.i.AndroidDemos.constant;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * Created by I on 2017/9/24.
 */

public class Constant {
    //searchhistoryActivity
    public static final String SEARCH_HISTORY_KEY = "SEARCH_HISTORY_KEY";

    public static final String URL_GITHUB = "https://api.github.com/";
    public static final String URL_EXPLORE = "http://trending.codehub-app.com/";
    public static final String URL_GANK = "http://gank.io/api/data/all/";
    public static final String URL_ARSENAL = "http://182.254.233.29/aresenal_api";
    // client id/secret
    public static final String CLIENT_ID = "82248be95d9d71c099b5";
    public static final String CLIENT_SECRET = "dd5afb626caf53f932a6b432c625c27b4214065e";

    public static final int[] tagColors = new int[]{
            Color.parseColor("#90C5F0"),
            Color.parseColor("#91CED5"),
            Color.parseColor("#F88F55"),
            Color.parseColor("#C0AFD0"),
            Color.parseColor("#E78F8F"),
            Color.parseColor("#67CCB7"),
            Color.parseColor("#F6BC7E")
    };
    // scopes
    public static final String[] SCOPES = {"user", "repo"};

    public static final String NOTE = "GitClub";

    public static final int PER_PAGE = 10;
    public static final int PER_PAGE_NEWS = 15;
    public static final int PER_PAGE_GANK = 10;
    public static final int PER_PAGE_ARSENAL = 15;

    public static List<String> mockStringList = Arrays.asList(
            "Android",
            "Github",
            "StackOverFlow",
            "AndroidWeekly",
            "LeetCode",
            "Youtube",
            "GeekPark",
            "JAVA编程思想",
            "算法导论",
            "网络是怎样连接的"
    );

    public interface SortType {
        SortType getBestMatch();

        String val();

        enum SortType_User implements SortType {
            BEST_MATCH("Best Match", null),
            FOLLOWERS("Followers", "followers"),
            REPOSITORIES("Repositories", "repositories"),
            JOINED("Joined", "joined");

            String display;
            String value;

            SortType_User(String key, String val) {
                display = key;
                value = val;
            }

            public static List<String> getDisplayStringList() {
                List<String> list = new ArrayList<>(4);
                for (SortType_User typeUser : SortType_User.values()) {
                    list.add(typeUser.display);
                }
                return list;
            }

            @Override
            public String val() {
                return value;
            }

            @Override
            public String toString() {
                return display;
            }

            @Override
            public SortType getBestMatch() {
                return SortType_User.BEST_MATCH;
            }

            public static SortType lookup(String key) {
                for (SortType_User typeUser : SortType_User.values()) {
                    if (!typeUser.display.equalsIgnoreCase(key))
                        continue;
                    return typeUser;
                }
                return SortType_Repo.BEST_MATCH;
            }

        }

        enum SortType_Repo implements SortType {
            BEST_MATCH("Best Match", null),
            STARS("Stars", "stars"),
            FORKS("Forks", "forks"),
            CREATED("Created", "created"),
            UPDATED("Updated", "updated");

            String display;
            String value;

            SortType_Repo(String key, String val) {
                display = key;
                value = val;
            }

            @Override
            public String val() {
                return value;
            }

            @Override
            public String toString() {
                return display;
            }

            @Override
            public SortType getBestMatch() {
                return SortType_Repo.BEST_MATCH;
            }

            public static List<String> getDisplayStringList() {
                List<String> list = new ArrayList<>(5);
                for (SortType_Repo typeRepo : SortType_Repo.values()) {
                    list.add(typeRepo.display);
                }
                return list;
            }

            public static List<String> getDisplayStringListForStarredRepo() {
                return Arrays.asList(CREATED.display, STARS.display, UPDATED.display);
            }

            public static SortType lookup(String key) {
                for (SortType_Repo typeRepo : SortType_Repo.values()) {
                    if (!typeRepo.display.equalsIgnoreCase(key))
                        continue;
                    return typeRepo;
                }
                return SortType_Repo.BEST_MATCH;
            }

        }

    }




}

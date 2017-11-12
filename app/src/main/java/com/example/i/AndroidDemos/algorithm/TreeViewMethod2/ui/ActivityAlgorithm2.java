package com.example.i.AndroidDemos.algorithm.TreeViewMethod2.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.i.AndroidDemos.MyApplication;
import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.algorithm.AlgorithmSort;
import com.example.i.AndroidDemos.algorithm.TreeViewMethod2.bean.Dir;
import com.example.i.AndroidDemos.algorithm.TreeViewMethod2.bean.File;
import com.example.i.AndroidDemos.algorithm.TreeViewMethod2.viewbinder.DirectoryNodeBinder;
import com.example.i.AndroidDemos.algorithm.TreeViewMethod2.viewbinder.FileNodeBinder;
import com.example.i.AndroidDemos.noteandtools.note.NoteDialogWithConfig;
import com.example.treeview.TreeNode;
import com.example.treeview.TreeViewAdapter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * Created by I on 2017/11/12.
 */

public class ActivityAlgorithm2 extends AppCompatActivity {
    @BindView(R.id.toolbar_activityalgorithm2)
    Toolbar toolbar;
    @BindView(R.id.rv_activityalgorithm2)
    RecyclerView recyclerView;
    private TreeViewAdapter adapter;
    private StringBuilder stringBuilder1 = new StringBuilder("");
    private int[] data;
    private Random random;
    private IncomingHandler handler;
    private String[] stringList_SortAlgorithm = {"基数排序"
            , "桶排序"
            , "计数排序"
            , "归并排序"
            , "希尔排序"
            , "堆排序"
            , "插入排序"
            , "快速排序"
            , "选择排序"
            , "冒泡排序"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm2);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initData() {
        handler = new IncomingHandler(this);
        data = new int[10000];
        random = new Random();
        for (int i = 0; i < 10000; i++) {
            data[i] = random.nextInt(10000000);
        }
        List<TreeNode> nodes = new ArrayList<>();
        //---------------------------------------------------------------------
        TreeNode<File> newfile = new TreeNode<>(new File("Description"));
        nodes.add(newfile);
        //-----------------------------------------------------------------------
        TreeNode<Dir> interview = new TreeNode<>(new Dir("Interview"));
        nodes.add(interview);
        TreeNode<Dir> easy = new TreeNode<>(new Dir("Easy"));
        TreeNode<Dir> medium = new TreeNode<>(new Dir("Medium"));
        TreeNode<Dir> hard = new TreeNode<>(new Dir("Hard"));
        interview.addChild(easy);
        interview.addChild(medium);
        interview.addChild(hard);
        //-------------------------------------------------------------------------
        TreeNode<Dir> basic = new TreeNode<>(new Dir("Basic"));
        nodes.add(basic);
        TreeNode<Dir> sort = new TreeNode<>(new Dir("Sort"));
        basic.addChild(sort);
        for (String s : stringList_SortAlgorithm) {
            sort.addChild(new TreeNode<>(new File(s)));
        }
        //-------------------------------------------------------------------------
        TreeNode<Dir> num = new TreeNode<>(new Dir("Number"));
        nodes.add(num);
        for (String s : stringList_SortAlgorithm) {
            num.addChild(new TreeNode<>(new File(s)));
        }
        //-------------------------------------------------------------------------
        TreeNode<Dir> str = new TreeNode<>(new Dir("String"));
        nodes.add(str);
        for (String s : stringList_SortAlgorithm) {
            str.addChild(new TreeNode<>(new File(s)));
        }
        //-------------------------------------------------------------------------


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TreeViewAdapter(nodes, Arrays.asList(new FileNodeBinder(), new DirectoryNodeBinder()));
        // whether collapse child nodes when their parent node was close.
//        adapter.ifCollapseChildWhileCollapseParent(true);
        adapter.setOnTreeNodeListener(new TreeViewAdapter.OnTreeNodeListener() {
            @Override
            public boolean onClick(final TreeNode node, RecyclerView.ViewHolder holder) {
                if (!node.isLeaf()) {
                    //Update and toggle the node.
                    onToggle(!node.isExpand(), holder);
                    if (!node.isExpand())
                        adapter.collapseBrotherNode(node);
                } else if (node.getContent().getLayoutId() == (new File("wodeshijie")).getLayoutId()) {//先判断打开的是文件夹还是文件，如果是文件夹就不用弹出toast了，即使它是空的文件夹
                    Toast.makeText(ActivityAlgorithm2.this, ((File) (node.getContent())).fileName + "进行中...", Toast.LENGTH_SHORT).show();
                    switch (((File) (node.getContent())).fileName) {
                        case "冒泡排序":
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    long begintime = System.currentTimeMillis();
                                    AlgorithmSort.bubbleMySort(data);
                                    long usedtime = System.currentTimeMillis() - begintime;
                                    Message msg0 = new Message();
                                    Bundle bundle = new Bundle();
                                    bundle.putInt(((File) (node.getContent())).fileName, (int) usedtime);
                                    msg0.setData(bundle);
                                    msg0.obj = data;
                                    msg0.what = 0;
                                    handler.sendMessage(msg0);
                                }
                            }).start();
                            break;
                        case "选择排序":
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    long begintime = System.currentTimeMillis();
                                    AlgorithmSort.selectSort(data);
                                    long usedtime = System.currentTimeMillis() - begintime;
                                    Message msg1 = new Message();//同时用obj和bundle传递数据
                                    msg1.obj = data;
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("选择排序", (int) usedtime);
                                    msg1.setData(bundle);
                                    msg1.what = 1;
                                    handler.sendMessage(msg1);
                                }
                            }).start();
                            break;
                        case "快速排序":
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    long begintime = System.currentTimeMillis();
                                    AlgorithmSort.quickSort(data, 0, data.length - 1);
                                    long usedtime = System.currentTimeMillis() - begintime;
                                    Message msg2 = new Message();
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("快速排序", (int) usedtime);
                                    msg2.obj = data;
                                    msg2.what = 2;
                                    msg2.setData(bundle);
                                    handler.sendMessage(msg2);
                                }
                            }).start();
                            break;
                    }

                }
                return false;
            }

            @Override
            public void onToggle(boolean isExpand, RecyclerView.ViewHolder holder) {
                DirectoryNodeBinder.ViewHolder dirViewHolder = (DirectoryNodeBinder.ViewHolder) holder;
                final ImageView ivArrow = dirViewHolder.getIvArrow();
                int rotateDegree = isExpand ? 90 : -90;
                ivArrow.animate().rotationBy(rotateDegree)
                        .start();
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void initView() {
        toolbar.setTitle("Algorithm Note");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_three_dot, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        adapter.collapseAll();
        return super.onOptionsItemSelected(item);
    }

    static class IncomingHandler extends Handler {
        private final WeakReference<ActivityAlgorithm2> activityAlgorithm2WeakReference;

        IncomingHandler(ActivityAlgorithm2 activityAlgorithm2) {
            activityAlgorithm2WeakReference = new WeakReference<>(activityAlgorithm2);
        }

        @Override
        public void handleMessage(Message msg) {
            ActivityAlgorithm2 activityAlgorithm2 = activityAlgorithm2WeakReference.get();
            if (activityAlgorithm2 != null) {
                switch (msg.what) {
                    case 0:
                        StringBuilder stringBuilder1 = new StringBuilder("");
                        for (int i = 0; i < 200; i++) {
                            stringBuilder1.append((((int[]) msg.obj)[i])).append("><");//单线程用stringbuilder
                        }
                        new NoteDialogWithConfig
                                .Builder(MyApplication.getContext())
                                .setTitle("一万个随机数排序用时:" + msg.getData().getInt("冒泡排序") + "ms")
                                .setMessage(stringBuilder1.toString())
                                .setCancelAble(true)
                                .create()
                                .show();
                        break;
                    case 1:
                        StringBuilder stringBuilder2 = new StringBuilder();
                        for (int i = 0; i < 200; i++) {
                            stringBuilder2.append((((int[]) msg.obj)[i])).append("><");//单线程用stringbuilder
                        }
                        new NoteDialogWithConfig.Builder(MyApplication.getContext())
                                .setTitle("一万个随机数排序用时:" + msg.getData().getInt("选择排序") + "ms")
                                .setMessage(stringBuilder2.toString())
                                .setCancelAble(true)
                                .create()
                                .show();
                        break;
                    case 2:
                        StringBuilder stringBuilder3 = new StringBuilder();
                        for (int i = 0; i < 200; i++) {
                            stringBuilder3.append((((int[]) msg.obj)[i])).append("><");//单线程用stringbuilder
                        }
                        new NoteDialogWithConfig.Builder(MyApplication.getContext())
                                .setTitle("一万个随机数排序用时:" + msg.getData().getInt("快速排序") + "ms")
                                .setMessage(stringBuilder3.toString())
                                .setCancelAble(true)
                                .create()
                                .show();
                        break;
                }
            }
        }
    }

}

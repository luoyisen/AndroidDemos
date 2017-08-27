package com.example.i.observerpatterndemo.Interreactcomponent;

import android.os.Bundle;
import android.widget.Toast;

import com.example.i.observerpatterndemo.Interreactcomponent.FragmentToActivity.FragmentInterreact;
import com.example.i.observerpatterndemo.Interreactcomponent.FragmentToActivity.MyListener;
import com.example.i.observerpatterndemo.R;
import com.example.i.observerpatterndemo.base.BaseActivityWithLL;

import org.jetbrains.annotations.Nullable;

/**
 * Created by I on 2017/8/23.
 */

/**
 * show()，hide()最终是让Fragment的View setVisibility(true还是false)，不会调用生命周期；
 * replace()的话会销毁视图，即调用onDestoryView、onCreateView等一系列生命周期；
 * add()和 replace()不要在同一个阶级的FragmentManager里混搭使用。
 * 如果你有一个很高的概率会再次使用当前的Fragment，建议使用show()，hide()，可以提高性能。
 * 在我使用Fragment过程中，大部分情况下都是用show()，hide()，而不是replace()。
 * 注意：如果你的app有大量图片，这时更好的方式可能是replace，配合你的图片框架在Fragment视图销毁时，回收其图片所占的内存。
 */
public class ComponentIntereactActivity extends BaseActivityWithLL implements MyListener {
    FragmentInterreact fragmentInterreact;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //因为baseActivityWithRecyclerView已经设置了布局文件，不用再次setcontentview
        fragmentInterreact = new FragmentInterreact();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.container_ll, fragmentInterreact, "fragment_root").commit();//// TODO: 2017/8/26 通过tag来识别是哪个fragment
    }

    /**
     * String s=null;
     * s.trim()就会抛出为空的exception
     * String s="";
     * s.trim()就不会抛,为什么?
     * NULL代表声明了一个空对象，根本就不是一个字符串。
     * ""代表声明了一个对象实例，这个对象实例的值是一个长度为0的空字符串。
     * NULL代表声明了一个空对象,对空对象做任何操作都不行的,除了=和==;""是一个字符串了,只是这个字符串里面没有内容了。
     * String s=null;只是定义了一个句柄，也就是说你有了个引用，但是这个引用未指向任何内存空间（只分配了栈内存，而没有分配堆内存）。
     * String s="";这个引用已经指向了一块是空字符串的内存空间，是一个实际的东东了，所以你可以对它操作，而不用担心什么了。
     * String.Trim()方法会去除字符串两端，不仅仅是空格字符，它总共能去除25种字符:
     * ('/t', '/n', '/v', '/f', '/r', ' ', '/x0085', '/x00a0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '
     * ', ' ', ' ', ' ', ' ', '?', '/u2028', '/u2029', ' ', '?')
     * 如果你想保留其中的一个或多个(例如/t制表符，/n换行符，/r回车符等)，请慎用Trim方法。
     * 请注意，Trim删除的过程为从外到内，直到碰到一个非空白的字符为止，所以不管前后有多少个连续的空白字符都会被删除掉。
     */
    @Override
    public void sendContent(String info) {
        if (info != null && !("".equals(info))) {
            currentItemTag = info;//// TODO: 2017/8/27  所有的共同维护这个String值
            Toast.makeText(this, info , Toast.LENGTH_SHORT).show();//TODO: 2017/8/26 用log查看sendContent是怎样调用的
        } else {
            Toast.makeText(this, "内容为空", Toast.LENGTH_SHORT).show();
        }
    }
}

package bowles.com.stuadmin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import bowles.com.stuadmin.R;
import bowles.com.stuadmin.model.stu_info;

public class stu_infoadapter extends BaseAdapter {
  private List<stu_info> infos;
  private LayoutInflater mInflater;
    public stu_infoadapter(Context context,List<stu_info> infos) {
        this.infos=infos;
        mInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return infos.size();
    }

    @Override
    public Object getItem(int position) {
        return infos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_stu_info, null);
            //对viewHolder的属性进行赋值
            viewHolder.stu_name =  convertView.findViewById(R.id.name);
            viewHolder.course_name =  convertView.findViewById(R.id.course);
            viewHolder.course_score = convertView.findViewById(R.id.score);
            //通过setTag将convertView与viewHolder关联
            convertView.setTag(viewHolder);
        }else{
            //如果缓存池中有对应的view缓存，则直接通过getTag取出viewHolder
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //开始填充数据
        stu_info sss=infos.get(position);
        viewHolder.course_name.setText(sss.getCourse_name());
        viewHolder.stu_name.setText(sss.getName());
        viewHolder.course_score.setText(sss.getCourse_score()+"");
        return convertView;
    }

    class ViewHolder{
        public TextView stu_name;
        public TextView course_name;
        public TextView course_score;
    }
}

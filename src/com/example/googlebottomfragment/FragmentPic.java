package com.example.googlebottomfragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class FragmentPic extends Fragment {
	/** Called when the activity is first created. */
	private int[] imageId = new int[] { R.drawable.img01, R.drawable.img02,
			R.drawable.img03, R.drawable.img04, R.drawable.img05,
			R.drawable.img06, R.drawable.img07, R.drawable.img08,
/*			R.drawable.img09, R.drawable.img10, R.drawable.img11,
			R.drawable.img12, R.drawable.img13, R.drawable.img14,
			R.drawable.img15, R.drawable.img16, */
			}; // ���岢��ʼ������ͼƬid������
	private ImageSwitcher imageSwitcher; // ����һ��ͼ���л�������
    public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.pic, null);
		imageSwitcher = (ImageSwitcher)view.findViewById(R.id.imageSwitcher1); // ��ȡͼ���л���
		// ���ö���Ч��
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(),
				android.R.anim.fade_in)); // ���õ��붯��
		imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(),
				android.R.anim.fade_out)); // ���õ�������
		imageSwitcher.setFactory(new ViewFactory() {

			@Override
			public View makeView() {
				ImageView imageView = new ImageView(getActivity().getApplicationContext()); // ʵ����һ��ImageView��Ķ���
				imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); // ���ñ����ݺ�Ⱦ�������ͼ��
				imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
				return imageView; // ����imageView����
			}

		});
		imageSwitcher.setImageResource(imageId[0]);// ����Ĭ����ʾ��ͼ��
		GridView gridview = (GridView) view.findViewById(R.id.gridView1); // ��ȡGridView���
		/**********************ʹ��BaseAdapterָ��Ҫ��ʾ������*****************************/
		BaseAdapter adapter=new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				ImageView imageview;	//����ImageView�Ķ���
				if(convertView==null){
					imageview=new ImageView(getActivity().getApplicationContext());	//ʵ����ImageView�Ķ���
					/*************����ͼ��Ŀ�Ⱥ͸߶�******************/
					imageview.setAdjustViewBounds(true);
					imageview.setMaxWidth(1200);
					imageview.setMaxHeight(800);
					/**************************************************/
					imageview.setPadding(0, 0, 0, 0);		//����ImageView���ڱ߾�
				}else{
					imageview=(ImageView)convertView;
				}
				imageview.setImageResource(imageId[position]);	//ΪImageView����Ҫ��ʾ��ͼƬ
				return imageview;	//����ImageView
			}
			
			/* 
			 * ���ܣ���õ�ǰѡ���ID
			 * (non-Javadoc)
			 * @see android.widget.Adapter#getItemId(int)
			 */
			@Override
			public long getItemId(int position) {
				return position;
			}
			
			/* 
			 * ���ܣ���õ�ǰѡ��
			 * (non-Javadoc)
			 * @see android.widget.Adapter#getItem(int)
			 */
			@Override
			public Object getItem(int position) {
				return position;
			}
			
			/*
			 * �������
			 *  (non-Javadoc)
			 * @see android.widget.Adapter#getCount()
			 */
			@Override
			public int getCount() {
				return imageId.length;
			}
		};
		/*********************************************************************************/
		gridview.setAdapter(adapter); // ����������GridView����
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				imageSwitcher.setImageResource(imageId[position]);// ��ʾѡ�е�ͼƬ
				
			}
			
		});
		return view;
	}
}
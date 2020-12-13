package com.example.favorite;

    public class adaptercd extends RecyclerView.Adapter<adaptercd.ViewHolder> {

        private ArrayList<String> mData = null ;

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView fav_stop1 ;

            ViewHolder(View itemView) {
                super(itemView) ;

                // 뷰 객체에 대한 참조. (hold strong reference)
                fav_stop1 = itemView.findViewById(R.id.fav1) ;
            }
        }

        adaptercd(ArrayList<String> list_937) {
            mData = list_937 ;
        }

        @Override
        public adaptercd.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext() ;
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

            View view = inflater.inflate(R.layout.recyclerview_item, parent, false) ;
            adaptercd.ViewHolder vh = new adaptercd.ViewHolder(view) ;

            return vh ;
        }

        @Override
        public void onBindViewHolder(adaptercd.ViewHolder holder, int position) {
            String text = mData.get(position) ;
            holder.fav_stop1.setText(text) ;
        }

        @Override
        public int getItemCount() {
            return mData.size() ;
        }
    }
}

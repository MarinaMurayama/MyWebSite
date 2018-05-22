package beans;

import java.io.Serializable;

public class ItemDataBeans implements Serializable {

	private int id;		 //商品ID
	private String item_num;    //型番
	private String taste_num;   //コーヒー豆分類
	private String item_img;    //商品画像ファイル名
	private String item_name;   //商品名
	private String item_detail; //商品説明
	private String category_id; //商品ジャンルID
	private int stocks;      //在庫数
	private int price;          //販売価格
	private String createDate;  //作成日時
	private String updateDate;  //更新日時


	// 全てのデータをセットするコンストラクタ(onlineshop_topとmasterで使用)
	public ItemDataBeans(int id, String itemnum, String taste,String img,String name,String detail,String category,int stocks,int price,String createDate,String updateDate) {
		this.id = id;
		this.item_num = itemnum;
		this.taste_num = taste;
		this.item_img = img;
		this.item_name = name;
		this.item_detail = detail;
		this.category_id = category;
		this.stocks = stocks;
		this.price = price;
		this.createDate = createDate;
		this.updateDate = updateDate;
			}


	public ItemDataBeans() {
		// TODO 自動生成されたコンストラクター・スタブ
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getItem_num() {
		return item_num;
	}
	public void setItem_num(String itemnum) {
		this.item_num = itemnum;
	}

	public String getTaste_num() {
		return taste_num;
	}
	public void setTaste_num(String taste) {
		this.taste_num = taste;
	}

	public String getItem_img() {
		return item_img;
	}
	public void setItem_img(String img) {
		this.item_img = img;
	}

	public String getName() {
		return item_name;
	}
	public void setName(String name) {
		this.item_name = name;
	}
	public String getDetail() {
		return item_detail;
	}
	public void setDetail(String detail) {
		this.item_detail = detail;
	}

	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category) {
		this.category_id = category;
	}

	public int getStocks() {
		return stocks;
	}
	public void setStocks(int stocks) {
		this.stocks = stocks;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}





}

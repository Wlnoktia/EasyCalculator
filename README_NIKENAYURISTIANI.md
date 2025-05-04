# EasyCalculator - Aplikasi Mobile Kalkulator

## Deskripsi Project
EasyCalculator adalah aplikasi kalkulator sederhana berbasis Android, dibuat untuk menghitung operasi matematika dasar seperti penjumlahan, pengurangan, perkalian, dan pembagian.
Aplikasi ini juga menyimpan riwayat perhitungan ke database lokal (SQLite) dan memungkinkan pengguna untuk melihat dan menghapus riwayat tersebut.

## Fitur Utama
- Kalkulator untuk operasi dasar.
- Riwayat perhitungan disimpan secara otomatis.
- Menghapus riwayat perhitungan satu per satu.
- Desain antarmuka sederhana dan mudah digunakan. 
- 
# 📱 Kalkulator Android – Adapter & Riwayat (Java)

Aplikasi kalkulator ini tidak hanya menghitung ekspresi matematika, tapi juga **menyimpan dan menampilkan riwayat kalkulasi** secara real-time menggunakan `RecyclerView` dan `Adapter` dalam Java.

---

## 🧩 Storyboard Fungsional – Riwayat & Adapter

### 🎯 Tujuan Fitur Riwayat

* Menampilkan daftar ekspresi dan hasil yang telah dihitung.
* Mempermudah pengguna melacak perhitungan sebelumnya.
* Memberikan pengalaman pengguna yang lebih profesional dan modern.

---

### 🧱 Komponen yang Digunakan

| Komponen            | Fungsi                                 |
| ------------------- | -------------------------------------- |
| `RecyclerView`      | Menampilkan daftar riwayat             |
| `Adapter`           | Menghubungkan data riwayat ke tampilan |
| `ArrayList<String>` | Menyimpan list ekspresi dan hasil      |

---

## 🛠 Struktur Kode Java

### 1. **Model Data (Opsional)**

Jika Anda ingin menggunakan pendekatan berbasis objek:

```java
public class HistoryItem {
    private String expression;
    private String result;

    public HistoryItem(String expression, String result) {
        this.expression = expression;
        this.result = result;
    }

    public String getExpression() { return expression; }
    public String getResult() { return result; }
}
```

---

### 2. **Layout Item Riwayat (`history_item.xml`)**

```xml
<TextView
    android:id="@+id/history_text"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="8dp"
    android:textColor="@color/black"
    android:textSize="16sp" />
```

---

### 3. **Adapter Java (`HistoryAdapter.java`)**

```java
public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private List<String> historyList;

    public HistoryAdapter(List<String> historyList) {
        this.historyList = historyList;
    }

    public static class HistoryViewHolder extends RecyclerView.ViewHolder {
        public TextView historyText;

        public HistoryViewHolder(View itemView) {
            super(itemView);
            historyText = itemView.findViewById(R.id.history_text);
        }
    }

    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.history_item, parent, false);
        return new HistoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {
        holder.historyText.setText(historyList.get(position));
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }
}
```

---

### 4. **Inisialisasi di MainActivity.java**

```java
RecyclerView recyclerView = findViewById(R.id.history_recycler_view);
List<String> historyList = new ArrayList<>();
HistoryAdapter adapter = new HistoryAdapter(historyList);

recyclerView.setLayoutManager(new LinearLayoutManager(this));
recyclerView.setAdapter(adapter);
```

---

### 5. **Menambahkan Riwayat Baru**

```java
String expression = "5 + 3";
String result = "8";
historyList.add(expression + " = " + result);
adapter.notifyDataSetChanged();
```

---

### 6. **Membersihkan Riwayat**

```java
historyList.clear();
adapter.notifyDataSetChanged();
```

---

## 🔁 Alur Riwayat: Visual Storyboard

```text
[User Tekan "="]
    ↓
[Ekspresi dihitung]
    ↓
[Tambahkan ke List<String>]
    ↓
[Adapter diberi tahu (notifyDataSetChanged)]
    ↓
[RecyclerView menampilkan hasil baru]
```
Link Repository
https://github.com/Wlnoktia/EasyCalculator.git

Link Trello Board (SCRUM Management)
https://wulanoktaviawahyu-1745597155870.atlassian.net/jira/software/projects/SCRUM/boards/1?sprintStarted=true&atlOrigin=eyJpIjoiM2ZiM2EzMTVmMmE4NDI2NGE0YTUwYjJjY2Y4Yjg5MjEiLCJwIjoiaiJ9
---

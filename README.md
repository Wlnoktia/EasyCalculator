
# EasyCalculator - Aplikasi Mobile Kalkulator

## Deskripsi Project
EasyCalculator adalah aplikasi kalkulator sederhana berbasis Android, dibuat untuk menghitung operasi matematika dasar seperti penjumlahan, pengurangan, perkalian, dan pembagian.
Aplikasi ini juga menyimpan riwayat perhitungan ke database lokal (SQLite) dan memungkinkan pengguna untuk melihat dan menghapus riwayat tersebut.

## Fitur Utama
- Kalkulator untuk operasi dasar.
- Riwayat perhitungan disimpan secara otomatis.
- Menghapus riwayat perhitungan satu per satu.
- Desain antarmuka sederhana dan mudah digunakan.


## 📖 Storyboard Logika & Event

### 1. **Event: Pengguna Menekan Tombol**

**Komponen:** `MaterialButton`
**Listener:** `OnClickListener`
**Logika Java:**

```java
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        expression += ((Button) v).getText().toString();
        solutionTextView.setText(expression);
    }
});
```

📌 *Tujuan:* Menambahkan input ke ekspresi matematika dan menampilkannya ke `solutionTextView`.

---

### 2. **Event: Tombol Sama Dengan (=)**

**Komponen:** `buttonEquals`
**Listener:** `OnClickListener`
**Logika Java:**

```java
buttonEquals.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String result = evaluate(expression);
        resultTextView.setText(result);
        historyList.add(expression + " = " + result);
        adapter.notifyDataSetChanged();
    }
});
```

📌 *Tujuan:* Mengevaluasi ekspresi dan menampilkan hasil pada `resultTextView`, serta menyimpan histori kalkulasi.

---

### 3. **Event: Tombol Clear (C)**

**Komponen:** `buttonC`
**Logika Java:**

```java
buttonC.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        expression = "";
        solutionTextView.setText("");
    }
});
```

📌 *Tujuan:* Menghapus ekspresi saat ini tanpa menghapus hasil atau histori.

---

### 4. **Event: Tombol All Clear (AC)**

**Komponen:** `buttonAC`
**Logika Java:**

```java
buttonAC.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        expression = "";
        resultTextView.setText("");
        solutionTextView.setText("");
        historyList.clear();
        adapter.notifyDataSetChanged();
    }
});
```

📌 *Tujuan:* Menghapus ekspresi, hasil kalkulasi, dan seluruh histori perhitungan.

---

### 5. **Evaluasi Ekspresi (Parsing)**

**Metode:** `evaluate(String expression)`
**Contoh Java menggunakan ekspresi evaluator (misal: `exp4j`):**

```java
public String evaluate(String expr) {
    try {
        Expression expression = new ExpressionBuilder(expr).build();
        double result = expression.evaluate();
        return String.valueOf(result);
    } catch (Exception e) {
        return "Error";
    }
}
```

📌 *Tujuan:* Mengubah string ekspresi menjadi hasil kalkulasi numerik dengan aman.

---

## 🔄 Alur Singkat Logika Event

```
[Tombol ditekan] → Tambah ekspresi → Tampilkan ke layar
[Tombol "=" ditekan] → Evaluasi ekspresi → Tampilkan hasil → Simpan ke histori
[Tombol "C"] → Hapus ekspresi
[Tombol "AC"] → Hapus ekspresi + hasil + histori
```


[ Calculator Screen ]
+-------------------------------+
|    Expression (5+7×2)          |
|    Result (19)                 |
|-------------------------------|
| 7 | 8 | 9 | ÷                 |
| 4 | 5 | 6 | ×                 |
| 1 | 2 | 3 | -                 |
| 0 | . | = | +                 |
|        [History Icon]         |
+-------------------------------+

[ History Screen ]
+--------------------------------+
| 5+7×2 = 19         [Delete]    |
| 9-2 = 7            [Delete]    |
| 8÷4 = 2            [Delete]    |
+--------------------------------+

## Teknologi yang Digunakan
- Java (Android Studio)
- SQLite Database
- RecyclerView
- Material Design Components

## Pembagian Tugas (Untuk 4 Orang)

| Nama | Tugas |
|------|-------|
| Watmah | UI/UX Design (Membuat tampilan kalkulator dan history) |
| Wahyu wulan | Pembuatan Kalkulasi dan Logika Event pada tombol |
| miranda | Pembuatan Database Helper dan CRUD SQLite untuk Riwayat |
| niken | Integrasi RecyclerView + Tombol Delete di Riwayat |

## Link Repository
> https://github.com/Wlnoktia/EasyCalculator.git

## Link Trello Board (SCRUM Management)
> https://wulanoktaviawahyu-1745597155870.atlassian.net/jira/software/projects/SCRUM/boards/1?sprintStarted=true&atlOrigin=eyJpIjoiM2ZiM2EzMTVmMmE4NDI2NGE0YTUwYjJjY2Y4Yjg5MjEiLCJwIjoiaiJ9

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../header.html" %>

<p>検索キーワードを入力してください。</p>
<form action="search" method="post" id="searchForm">
  <input type="text" name="keyword" id="keyword">
  <select name="priceRange">
    <option value="100-200">100-200円</option>
    <option value="200-300">200-300円</option>
    <option value="300-400">300-400円</option>
    <!-- 他の範囲も追加 -->
  </select>
  <input type="submit" value="検索">
</form>

<script>
document.getElementById('searchForm').addEventListener('submit', function(event) {
  var keyword = document.getElementById('keyword').value;
  if (keyword.trim().length > 10) {
    alert('キーワードは10文字以内で入力してください。');
    event.preventDefault();  // フォームの送信を防止
  }
});
</script>

<%@ include file="../footer.html" %>

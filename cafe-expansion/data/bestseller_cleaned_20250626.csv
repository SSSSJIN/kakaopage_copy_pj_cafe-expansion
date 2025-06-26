import pandas as pd
import os

# 파일 경로 설정
DATA_DIR = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'data')
xls_file = os.path.join(DATA_DIR, 'alradin_jugan-beseuteu_gugnaedoseo_2025nyeon6weol3ju_20250626.xls')
csv_file = os.path.join(DATA_DIR, 'bestseller_cleaned_20250626.csv')

# 1. 엑셀 파일 읽기
df = pd.read_excel(xls_file)

# 2. 컬럼명 확인 및 필요한 컬럼만 추출
# 원본 컬럼명: 순번/순위,구분,상품명,ItemId,ISBN13,부가기호,저자/아티스트,출판사/제작사,출간일,정가,판매가,마일리지,세일즈포인트,대표분류(대분류명)
cols = [
    '순번/순위', '상품명', 'ItemId', 'ISBN13', '저자/아티스트', '출판사/제작사', '출간일',
    '정가', '판매가', '세일즈포인트', '대표분류(대분류명)'
]
df = df[cols]

# 3. 컬럼명 영문으로 변경
df = df.rename(columns={
    '순번/순위': 'Rank',
    '상품명': 'BName',
    'ItemId': 'ItemId',
    'ISBN13': 'ISBN13',
    '저자/아티스트': 'Author',
    '출판사/제작사': 'Publisher',
    '출간일': 'PubDate',
    '정가': 'Price',
    '판매가': 'SalePrice',
    '세일즈포인트': 'SalesPoint',
    '대표분류(대분류명)': 'Category'
})

# 4. 숫자 컬럼에서 콤마 제거 및 int 변환
for col in ['Price', 'SalePrice', 'SalesPoint']:
    df[col] = df[col].astype(str).str.replace(',', '').str.replace('점', '')
    df[col] = pd.to_numeric(df[col], errors='coerce')

# 5. 출간일 날짜형 변환
df['PubDate'] = pd.to_datetime(df['PubDate'], format='%Y%m%d', errors='coerce')

# 6. 최종 저장
df.to_csv(csv_file, index=False, encoding='utf-8-sig')

print(f'완료! {csv_file}로 저장되었습니다.')
